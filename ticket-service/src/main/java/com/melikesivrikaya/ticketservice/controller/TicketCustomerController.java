package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.converter.TicketConverter;
import com.melikesivrikaya.ticketservice.dto.TicketResponse;
import com.melikesivrikaya.ticketservice.dto.enums.Gender;
import com.melikesivrikaya.ticketservice.dto.enums.Rate;
import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.service.TicketCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/tickets/customer")
public class TicketCustomerController {

    private final TicketCustomerService ticketCustomerService;

    @Cacheable(value = "tickets" , cacheNames = "tickets")
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketCustomerService.findAll();
    }

    @GetMapping("{ticketId}/{gender}")
    public TicketResponse addBasket(@PathVariable Long ticketId, @PathVariable Gender gender) {
        return TicketConverter.toResponse(ticketCustomerService.addBasket(ticketId,gender));
    }

    @CacheEvict(cacheNames = "tickets", allEntries = true)
    @GetMapping("/approval")
    public List<TicketResponse> approvalBasket(@RequestHeader("userType") String userType,@RequestHeader("userId") String userId ) {
        return ticketCustomerService.approvalBasket(userType,userId).stream().map(TicketConverter::toResponse).toList();
    }

    @CacheEvict(cacheNames = "tickets", allEntries = true)
    @GetMapping("/rate/{rate}")
    public void ticketsPayment(@RequestHeader("userId") String userId, @PathVariable Rate rate){
        ticketCustomerService.ticketsPayment(Long.valueOf(userId),rate);
    }

    @DeleteMapping("{ticketId}")
    public void removeBasket(@PathVariable Long ticketId) {
        ticketCustomerService.removeBasket(ticketId);
    }
}
