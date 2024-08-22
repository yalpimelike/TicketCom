package com.melikesivrikaya.indexservice.converter;

import com.melikesivrikaya.indexservice.model.Trip;
import com.melikesivrikaya.indexservice.model.TripDocument;


public class TripConverter {

    public static TripDocument toDocument(Trip trip){
        return TripDocument.builder()
                .id(String.valueOf(trip.getId()))
                .price(trip.getPrice())
                .tripType(String.valueOf(trip.getTripType()))
                .startDate(String.valueOf(trip.getStartDate()))
                .endDate(String.valueOf(trip.getEndDate()))
                .startCity(String.valueOf(trip.getStartCity()))
                .endCity(String.valueOf(trip.getEndCity()))
                .occupant(trip.getOccupant())
                .build();
    }

    // TODO buraya tarih formatlama ekle

    public static Trip toEnttiy(TripDocument tripDocument) {
        return Trip.builder()
                .id(Long.valueOf(tripDocument.getId()))
                .price(tripDocument.getPrice())
                .endCity(tripDocument.getEndCity())
                .startCity(tripDocument.getStartCity())
                .occupant(tripDocument.getOccupant())
                .build();
    }
}
