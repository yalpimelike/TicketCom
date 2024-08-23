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

    @PostMapping("/list")
    public List<Ticket> createTicketList(@RequestBody List<Ticket> ticketList) {
        return ticketService.createTicketList(ticketList);
    }

    @GetMapping("{ticketSize}/{tripId}")
    public void createTickets(@PathVariable int ticketSize, @PathVariable Long tripId) {
        ticketService.createTickets(ticketSize,tripId);
    }

    @DeleteMapping("/{ticketId}")
    public void delete(@PathVariable Long ticketId) {
        ticketService.delete(ticketId);
    }
}
