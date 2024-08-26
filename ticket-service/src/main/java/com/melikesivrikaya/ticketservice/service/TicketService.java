package com.melikesivrikaya.ticketservice.service;

import com.melikesivrikaya.ticketservice.dto.CreateTicketListRequest;
import com.melikesivrikaya.ticketservice.exception.ExceptionMessages;
import com.melikesivrikaya.ticketservice.exception.TicketException;
import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public void delete(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public List<Ticket> createTicketList(List<Ticket> ticketList) {
        return ticketRepository.saveAll(ticketList);
    }

    public void createTickets(CreateTicketListRequest request) {
        try{
            List<Ticket> ticketList = new ArrayList<>();
            for (int i = 1; i <= request.getTicketSize(); i++) {
                ticketList.add(new Ticket(request.getTripId() , i,false,false, request.getPrice()));
            }
            ticketRepository.saveAll(ticketList);
        }catch (Exception e){
            log.error(ExceptionMessages.NO_SAVE);
            throw new TicketException(ExceptionMessages.NO_SAVE);
        }

    }
}
