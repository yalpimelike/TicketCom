package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.converter.TicketConverter;
import com.melikesivrikaya.ticketservice.dto.TicketResponse;
import com.melikesivrikaya.ticketservice.dto.enums.Rate;
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
    public TicketResponse addBasket(@PathVariable Long ticketId) {
        return TicketConverter.toResponse(ticketCustomerService.addBasket(ticketId));
    }

    @GetMapping("/approval")
    public List<TicketResponse> approvalBasket(@RequestHeader("userType") String userType,@RequestHeader("userId") String userId ) {
        return ticketCustomerService.approvalBasket(userType,userId).stream().map(TicketConverter::toResponse).toList();
    }

    @GetMapping("/rate/{rate}")
    public void ticketsPayment(@RequestHeader("userId") String userId, @PathVariable Rate rate){
        ticketCustomerService.ticketsPayment(Long.valueOf(userId),rate);
    }

    @DeleteMapping("{ticketId}")
    public void removeBasket(@PathVariable Long ticketId) {
        ticketCustomerService.removeBasket(ticketId);
    }
}
