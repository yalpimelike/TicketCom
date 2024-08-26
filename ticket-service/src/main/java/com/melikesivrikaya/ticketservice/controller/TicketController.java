package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.dto.CreateTicketListRequest;
import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    @Cacheable(value = "tickets" , cacheNames = "tickets")
    @GetMapping
    public List<Ticket> getAllTickets() {
        log.info("Database den getirdi");
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

    @CacheEvict(cacheNames = "tickets", allEntries = true)
    @PostMapping("/createList")
    public void createTickets(@RequestBody CreateTicketListRequest request) {
        ticketService.createTickets(request);
    }

    @DeleteMapping("/{ticketId}")
    public void delete(@PathVariable Long ticketId) {
        ticketService.delete(ticketId);
    }
}
