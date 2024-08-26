package com.melikesivrikaya.tripservice.converter;

import com.melikesivrikaya.tripservice.dto.TripResponse;
import com.melikesivrikaya.tripservice.model.Trip;

public class TripConverter {

    public static TripResponse toResponse(Trip trip) {
        return TripResponse.builder()
                .startCity(trip.getStartCity())
                .endCity(trip.getEndCity())
                .startDate(trip.getStartDate())
                .endDate(trip.getEndDate())
                .price(trip.getPrice())
                .build();
    }
}
