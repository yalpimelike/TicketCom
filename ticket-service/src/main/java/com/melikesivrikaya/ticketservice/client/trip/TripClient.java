package com.melikesivrikaya.ticketservice.client.trip;

import com.melikesivrikaya.ticketservice.dto.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "trip-service" , url = "localhost:1010/api/v1/trips")
public interface TripClient {
    @GetMapping("{tripId}")
    Trip getTripById(@PathVariable Long tripId);

    @GetMapping("{tripId}/{count}")
    void soldTicketCountSubtract(@PathVariable Long tripId,@PathVariable int count);
}
