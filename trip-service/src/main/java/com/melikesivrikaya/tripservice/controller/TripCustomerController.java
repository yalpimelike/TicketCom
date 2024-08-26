package com.melikesivrikaya.tripservice.controller;

import com.melikesivrikaya.tripservice.client.order.OrderClientService;
import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trips/customer")
public class TripCustomerController {

    private final OrderClientService orderClientService;
    private final TripService tripService;

    @PostMapping
    public Trip create(@RequestBody Trip trip,@RequestHeader("userId") String userId) {
        return tripService.create(trip,userId);
    }

    @DeleteMapping("{tripId}")
    public void delete(@PathVariable Long tripId) {
        tripService.delete(tripId);
    }

    @GetMapping("/count/{tripId}")
    public int totalSoldTicketCount(@PathVariable Long tripId) {
        return orderClientService.totalSoldTicketCount(tripId);
    }

    @GetMapping("/price/{tripId}")
    public int totalSoldTicketPrice(@PathVariable Long tripId) {
        return orderClientService.totalSoldTicketPrice(tripId);
    }
}
