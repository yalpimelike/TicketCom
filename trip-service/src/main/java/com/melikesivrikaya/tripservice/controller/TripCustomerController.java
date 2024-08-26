package com.melikesivrikaya.tripservice.controller;

import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.service.TripCustomerService;
import com.melikesivrikaya.tripservice.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trips/customer")
public class TripCustomerController {

    private final TripCustomerService tripCustomerService;
    private final TripService tripService;

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripService.create(trip);
    }

    @DeleteMapping("{tripId}")
    public void delete(@PathVariable Long tripId) {
        tripService.delete(tripId);
    }

    @GetMapping("/count/{tripId}")
    public int totalBuyTicketCount(@PathVariable Long tripId) {
        return 0;
    }

    @GetMapping("/price/{tripId}")
    public int totalBuyTicketPrice(@PathVariable Long tripId) {
        return 0;
    }
}
