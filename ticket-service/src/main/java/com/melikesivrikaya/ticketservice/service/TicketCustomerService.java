package com.melikesivrikaya.ticketservice.service;

import com.melikesivrikaya.ticketservice.client.payment.PaymentClientService;
import com.melikesivrikaya.ticketservice.client.trip.TripClientService;
import com.melikesivrikaya.ticketservice.dto.Order;
import com.melikesivrikaya.ticketservice.dto.Payment;
import com.melikesivrikaya.ticketservice.dto.PaymentRequest;
import com.melikesivrikaya.ticketservice.dto.Trip;
import com.melikesivrikaya.ticketservice.dto.enums.Rate;
import com.melikesivrikaya.ticketservice.dto.enums.TicketForOrder;
import com.melikesivrikaya.ticketservice.dto.enums.UserType;
import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TicketCustomerService {

    private final TicketRepository ticketRepository;
    private final Map<Long, List<Ticket>> ticketList = new HashMap<>();
    private final List<Ticket> basket = new ArrayList<>();
    private final TicketService ticketService;
    private final TripClientService tripClientService;
    private final PaymentClientService paymentClientService;
    private int maleTravellerCount = 0;
    private int totalPrice = 0 ;


    public List<Ticket> approvalBasket(){

        // Sepetteki biletleri teyit ediyor tekrar
        // Validate için ayrı bir liste ekliyor
        // Ticket ları reserve ediyor
        // ticketList e ekliyor
        basket.forEach(ticket -> {
            Ticket currentTicket = ticketRepository.findById(ticket.getId()).orElse(null);
            if (currentTicket == null){
                throw new RuntimeException("Bilet artık bulunamamaktadır.");
            } else if (ticket.isReserved()) {
                throw new RuntimeException("Ticket is reserved");
            }
            // Mevcut tripId için listeyi al, yoksa yeni bir liste oluştur
            ticketList.computeIfAbsent(ticket.getTripId(), k -> new ArrayList<>()).add(currentTicket);
            ticket.setReserved(true);
        });
        ticketService.createTicketList(basket);
        return basket;
    }

    // Eğer bilet ödeme aşamasında değilse sepete ekliyor
    public Ticket addBasket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null ) {
            throw new RuntimeException("Ticket not found");
        } else if (ticket.isReserved()) {
            throw new RuntimeException("Ticket is reserved");
        }
        basket.add(ticket);
        return ticket;
    }

    public void validateBasket(String userType,String userId){

        ticketList.forEach((k, v) -> {
           // Kullsnıcının bu sefer için daha önce almış olduğu bilet sayısı
           List<Ticket> ticketsByUser =  ticketRepository.findByUserIdAndTripId(Long.valueOf(userId),k).orElse(null);
           if (ticketsByUser != null){
               int ticketCountByUser = ticketsByUser.size();
               int totalTicketCountByUser = ticketCountByUser + v.size();
               int maxTickets = 0 ;
               if (userType.equals(String.valueOf(UserType.CORPORATE))){
                   maxTickets = 40;
               } else if (userType.equals(String.valueOf(UserType.INDIVIDUAL))) {
                   maxTickets = 4;
               }
               if (totalTicketCountByUser > maxTickets){
                   throw new RuntimeException("Aynı sefer için maximium bilet sayısını aştınız. max alabileceğiniz  : " + (maxTickets - ticketCountByUser));
               }
               v.forEach(ticket -> {
                   if (String.valueOf(ticket.getTravellerGender()).equals("MALE")){
                       maleTravellerCount += 1;
                   }
               });
           }
        });
        if (userType.equals(String.valueOf(UserType.CORPORATE)) && maleTravellerCount > 2) {
            throw new RuntimeException("Bir siparişte en fazla 2 erkek yolcu alınbilir");
        }
    }

    public void ticketsPayment(Long userId) {
        // TODO gelen rate i requestten al
        Payment payment = paymentClientService.paymentTickets(new PaymentRequest(userId, Rate.CREDIT_CART,totalPrice)).orElse(null);
        if (payment != null){
            //order oluştur ve kafka ile notification a gönder
            Order order = new Order();
            List<TicketForOrder> ticketForOrderList = new ArrayList<>();
            ticketList.forEach((k, v) -> {
                v.forEach(ticket -> {
                    ticketForOrderList.add(new TicketForOrder(ticket,tripClientService.getTripById(k)));
                });
            });
            order.setTickets(ticketForOrderList);
            order.setRate(Rate.CREDIT_CART);
            order.setUserId(userId);
            order.setTotalPrice(totalPrice);

            // TODO kafka ile gönder
        }

    }
}
