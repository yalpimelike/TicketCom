package com.melikesivrikaya.ticketservice.service;

import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void delete(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
