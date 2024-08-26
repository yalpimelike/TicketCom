package com.melikesivrikaya.ticketservice.service;

import com.melikesivrikaya.ticketservice.client.payment.PaymentClientService;
import com.melikesivrikaya.ticketservice.client.trip.TripClientService;
import com.melikesivrikaya.ticketservice.dto.*;
import com.melikesivrikaya.ticketservice.dto.enums.Gender;
import com.melikesivrikaya.ticketservice.dto.enums.Rate;
import com.melikesivrikaya.ticketservice.dto.enums.UserType;
import com.melikesivrikaya.ticketservice.exception.ExceptionMessages;
import com.melikesivrikaya.ticketservice.exception.TicketException;
import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.producer.KafkaProducer;
import com.melikesivrikaya.ticketservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketCustomerService {

    private final TicketRepository ticketRepository;
    private final Map<Long, List<Ticket>> ticketList = new HashMap<>();
    private final List<Ticket> basket = new ArrayList<>();
    private final TicketService ticketService;
    private final TripClientService tripClientService;
    private final PaymentClientService paymentClientService;
    private int maleTravellerCount = 0;
    private int totalPrice = 0 ;
    private final KafkaProducer kafkaProducer;


    public Ticket addBasket(Long ticketId, Gender gender) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null ) {
            log.error(ExceptionMessages.TICKET_NOT_FOUNT);
            throw new TicketException(ExceptionMessages.TICKET_NOT_FOUNT);
        } else if (ticket.isReserved()) {
            log.error(ExceptionMessages.TICKET_RESERVED);
            throw new TicketException(ExceptionMessages.TICKET_RESERVED);
        }
        if (basket.stream().anyMatch(ticket1 -> ticket1.getId().equals(ticketId))){
            log.error(ExceptionMessages.TICKET_ADDED_BASKET);
            throw new TicketException(ExceptionMessages.TICKET_ADDED_BASKET);
        }
        ticket.setTravellerGender(gender);
        basket.add(ticket);
        log.info(TicketConstants.ADDED_TICKET_TO_BASKET);
        return ticket;
    }


    public List<Ticket> approvalBasket(String userType,String userId){

        basket.forEach(ticket -> {
            Ticket currentTicket = ticketRepository.findById(ticket.getId()).orElse(null);
            if (currentTicket == null){
                log.error(ExceptionMessages.TICKET_NOT_FOUNT);
                throw new TicketException(ExceptionMessages.TICKET_NOT_FOUNT);
            } else if (ticket.isReserved()) {
                log.error(ExceptionMessages.TICKET_RESERVED);
                throw new TicketException(ExceptionMessages.TICKET_RESERVED);
            }
            ticketList.computeIfAbsent(ticket.getTripId(), k -> new ArrayList<>()).add(currentTicket);
            ticket.setReserved(true);
        });
        ticketService.createTicketList(basket);
        try {
            ticketRepository.saveAll(basket);
        }catch (Exception e){
            log.error(ExceptionMessages.NO_SAVE);
        }
        log.info(TicketConstants.APPROVAL_BASKET);
        validateBasket(userType,userId);
        return basket;
    }


    public void validateBasket(String userType,String userId){

        ticketList.forEach((k, v) -> {

           List<Ticket> ticketsByUser =  ticketRepository.findByUserIdAndTripId(Long.valueOf(userId),k).orElse(null);

           if (ticketsByUser != null){
               int ticketCountByUser = ticketsByUser.size();
               int totalTicketCountByUser = ticketCountByUser + v.size();
               int maxTickets = 0 ;

               if (userType.equals(String.valueOf(UserType.CORPORATE))){
                   maxTickets = TicketConstants.CORPORATE_USER_MAX_TICKET;
               } else if (userType.equals(String.valueOf(UserType.INDIVIDUAL))) {
                   maxTickets = TicketConstants.INDIVIDUAL_USER_MAX_TICKET;
               }
               if (totalTicketCountByUser > maxTickets){
                   log.error(ExceptionMessages.MAX_TICKET_EXCEED);
                   throw new TicketException(ExceptionMessages.MAX_TICKET_EXCEED + (maxTickets - ticketCountByUser));
               }
               v.forEach(ticket -> {
                   if (String.valueOf(ticket.getTravellerGender()).equals(String.valueOf(Gender.MALE))){
                       maleTravellerCount += 1;
                   }
               });
           }
        });
        if (userType.equals(String.valueOf(UserType.CORPORATE)) && maleTravellerCount > TicketConstants.CORPORATE_USER_MAX_MALE_TICKET) {
            log.error(ExceptionMessages.MAX_MALE_TRAVELLER);
            throw new TicketException(ExceptionMessages.MAX_MALE_TRAVELLER);
        }
        log.info(TicketConstants.VALIDATE_BASKET);
    }

    public void ticketsPayment(Long userId,Rate rate) {

        List<Ticket> paymentTicket = new ArrayList<>();
        Payment payment = paymentClientService.paymentTickets(new PaymentRequest(userId, rate,totalPrice)).orElse(null);
        if (payment != null){

            Order order = new Order();
            List<TicketForOrder> ticketForOrderList = new ArrayList<>();
            ticketList.forEach((k, v) -> {
                v.forEach(ticket -> {
                    ticket.setIsPayment(true);
                    ticketForOrderList.add(new TicketForOrder(ticket,tripClientService.getTripById(k)));
                    paymentTicket.add(ticket);
                });
                tripClientService.soldTicketCountSubtract(k,v.size());

            });

            order.setTickets(ticketForOrderList);
            order.setRate(rate);
            order.setUserId(userId);
            order.setTotalPrice(totalPrice);

            kafkaProducer.sendNotification(order);
        }
        try {
            ticketRepository.saveAll(paymentTicket);
            ticketList.clear();
            basket.clear();
        }catch (Exception e){
            log.error(ExceptionMessages.NO_SAVE);
        }
    }

    public void removeBasket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null){
            basket.remove(ticket);
        }
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

}
