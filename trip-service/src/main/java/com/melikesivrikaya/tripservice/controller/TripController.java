package com.melikesivrikaya.tripservice.controller;

import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripService tripService;

    // Adminin ulaşabileceği yer burası

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripService.create(trip);
    }

    @GetMapping
    public List<Trip> getAll() {
        return tripService.getAll();
    }

    @DeleteMapping("{tripId}")
    public void delete(@PathVariable Long tripId) {
        tripService.delete(tripId);
    }

}
