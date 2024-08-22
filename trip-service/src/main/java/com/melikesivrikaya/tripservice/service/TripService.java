package com.melikesivrikaya.ticketservice.service;

import com.melikesivrikaya.ticketservice.model.Trip;
import com.melikesivrikaya.ticketservice.repository.TripRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TripService {

    private final TripRepository tripRepository;

    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }


}
