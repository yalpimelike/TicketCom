package com.melikesivrikaya.tripservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ticket-service" , url = "localhost:1014/api/v1/tickets")
public interface TicketClient {

    @GetMapping("{ticketSize}/{tripId}")
    void createTickets(@PathVariable int ticketSize, @PathVariable Long tripId);
}
