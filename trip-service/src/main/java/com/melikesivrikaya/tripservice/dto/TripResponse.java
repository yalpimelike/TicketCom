package com.melikesivrikaya.tripservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
public class TripResponse {

    private String startCity;
    private String endCity;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;

    private int travelerCount;
}
