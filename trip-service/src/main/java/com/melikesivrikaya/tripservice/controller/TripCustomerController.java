package com.melikesivrikaya.tripservice.controller;

import com.melikesivrikaya.tripservice.dto.TicketAddBasketRequest;
import com.melikesivrikaya.tripservice.model.Ticket;
import com.melikesivrikaya.tripservice.service.TripCustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trips/customer")
@RequiredArgsConstructor
public class TripCustomerController {

    private final TripCustomerService tripCustomerService;

    @PostMapping
    public Ticket ticketAddBasket(@RequestBody TicketAddBasketRequest request) {
        return tripCustomerService.ticketAddBasket(request);
    }

    @GetMapping
    public void payment(){

    }
}
