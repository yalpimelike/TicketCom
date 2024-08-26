package com.melikesivrikaya.ticketservice.client.trip;

import com.melikesivrikaya.ticketservice.dto.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripClientService {

    private final TripClient tripClient;

    public Trip getTripById(Long tripId) {
        return tripClient.getTripById(tripId);
    }
    public void soldTicketCountSubtract(Long tripId,int count){
        tripClient.soldTicketCountSubtract(tripId,count);
    }
}
