package com.melikesivrikaya.ticketservice.client.trip;

import com.melikesivrikaya.ticketservice.dto.Trip;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class TripClientService {

    private final TripClient tripClient;

    public Trip getTripById(Long tripId) {
        return tripClient.getTripById(tripId);
    }
}
