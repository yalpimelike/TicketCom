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
    public Trip create(@RequestBody Trip trip,@RequestHeader("userId") String userId) {
        return tripService.create(trip,userId);
    }

    @GetMapping
    public List<Trip> getAll() {
        return tripService.getAll();
    }

    @GetMapping("{tripId}/{count}")
    public void soldTicketCountSubtract(@PathVariable Long tripId,@PathVariable int count){
        tripService.soldTicketCountSubtract(tripId,count);
    }
    @GetMapping("{tripId}")
    public Trip getTripById(@PathVariable Long tripId) {
        return tripService.getTripById(tripId);
    }

    @GetMapping("/{tripId}/tickets")
    public Trip getAllBuyTickets(@PathVariable Long tripId) {
        return tripService.getAllBuyTickets(tripId);
    }

    @DeleteMapping("{tripId}")
    public void delete(@PathVariable Long tripId) {
        tripService.delete(tripId);
    }


}
