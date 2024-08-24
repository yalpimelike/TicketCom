package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.model.Ticket;
import com.melikesivrikaya.ticketservice.repository.TicketRepository;
import com.melikesivrikaya.ticketservice.service.TicketCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets/customer")
public class TicketCustomerController {

    private final TicketCustomerService ticketCustomerService;

    @GetMapping("{ticketId}")
    public Ticket addBasket(@PathVariable Long ticketId) {

        return ticketCustomerService.addBasket(ticketId);
    }

    @GetMapping
    public List<Ticket> approvalBasket() {
        return ticketCustomerService.approvalBasket();
    }

    @GetMapping("/1")
    public void validateBasket(@RequestHeader("userType") String userType,@RequestHeader("userId") String userId){
        ticketCustomerService.validateBasket(userType,userId);
    }

    @GetMapping("2")
    public void ticketsPayment(@RequestHeader("userId") String userId){
        ticketCustomerService.ticketsPayment(Long.valueOf(userId));
    }

    // TODO sepettençıkarma işlemi ekle
}
