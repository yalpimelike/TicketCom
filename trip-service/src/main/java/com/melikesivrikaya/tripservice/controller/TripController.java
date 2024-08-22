package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.model.Trip;
import com.melikesivrikaya.ticketservice.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripService tripService;

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripService.create(trip);
    }

    @GetMapping
    public List<Trip> getAll() {
        return tripService.getAll();
    }
}
