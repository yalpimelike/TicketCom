package com.melikesivrikaya.tripservice.service;

import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.model.enums.TripType;
import com.melikesivrikaya.tripservice.producer.KafkaProducer;
import com.melikesivrikaya.tripservice.repository.TripRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TripService {

    private final TripRepository tripRepository;
    private final KafkaProducer kafkaProducer;

    public Trip create(Trip trip) {
        if (trip.getTripType().equals(TripType.PLANE)){
            trip.setOccupant(189);
        } else if (trip.getTripType().equals(TripType.BUS)) {
            trip.setOccupant(45);
        }

        kafkaProducer.sendTrip(trip);
        return tripRepository.save(trip);
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public void delete(Long tripId) {
        tripRepository.deleteById(tripId);
    }
}
