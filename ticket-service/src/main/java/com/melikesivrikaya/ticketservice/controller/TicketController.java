package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.dto.CreateTicketListRequest;
import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;

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
