package com.melikesivrikaya.tripservice.controller;

import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripService tripService;

    @GetMapping("{tripId}/{count}")
    public void soldTicketCountSubtract(@PathVariable Long tripId,@PathVariable int count){
        tripService.soldTicketCountSubtract(tripId,count);
    }
    @GetMapping("{tripId}")
    public Trip getTripById(@PathVariable Long tripId) {
        return tripService.getTripById(tripId);
    }
}
