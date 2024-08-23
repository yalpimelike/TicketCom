package com.melikesivrikaya.ticketservice.service;

import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    // Daha önceden bileti almak istediiği sefer için bilet almışmı
    public int validateTicket(Long userId,Long tripId) {
        List<Ticket> ticketList = ticketRepository.findByUserIdAndTripId(userId,tripId).orElse(new ArrayList<>());
        if (ticketList.isEmpty()) {
            return 0;
        }
        return ticketList.size();
    }

    public List<Ticket> createTicketList(List<Ticket> ticketList) {
        return ticketRepository.saveAll(ticketList);
    }

    public void createTickets(int ticketSize,Long tripId) {
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 1; i <= ticketSize; i++) {
            ticketList.add(new Ticket(tripId,i,false,false));
        }
        ticketRepository.saveAll(ticketList);
    }
}
