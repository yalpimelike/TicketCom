package com.melikesivrikaya.tripservice.controller;

import com.melikesivrikaya.tripservice.converter.TripConverter;
import com.melikesivrikaya.tripservice.dto.TripResponse;
import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.service.TripService;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/trips")
public class TripController {

    private final TripService tripService;

    @PostMapping
    public TripResponse create(@RequestBody Trip trip) {
        return TripConverter.toResponse(tripService.create(trip));
    }

    @GetMapping
    public List<TripResponse> getAll() {
        return tripService.getAll().stream().map(TripConverter::toResponse).toList();
    }

    @GetMapping("{tripId}")
    public TripResponse getTripById(@PathVariable Long tripId) {
        return TripConverter.toResponse(tripService.getTripById(tripId));
    }

    @GetMapping("/{tripId}/tickets")
    public TripResponse getAllBuyTickets(@PathVariable Long tripId) {
        return TripConverter.toResponse(tripService.getAllBuyTickets(tripId));
    }


    @DeleteMapping("{tripId}")
    public void delete(@PathVariable Long tripId) {
        tripService.delete(tripId);
    }


}
