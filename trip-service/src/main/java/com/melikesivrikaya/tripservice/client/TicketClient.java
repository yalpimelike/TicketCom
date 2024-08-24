package com.melikesivrikaya.tripservice.client;

import com.melikesivrikaya.tripservice.dto.CreateTicketListRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ticket-service" , url = "localhost:1014/api/v1/tickets")
public interface TicketClient {

    @PostMapping("/createList")
    void createTickets(@RequestBody CreateTicketListRequest request);
}
