package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {




    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return ticketService.create(ticket);
    }

    @DeleteMapping("/{ticketId}")
    public void delete(@PathVariable Long ticketId) {
        ticketService.delete(ticketId);
    }
}
