package com.melikesivrikaya.indexservice.model;

import com.melikesivrikaya.indexservice.model.enums.TripType;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    private Long id;
    private String startCity;
    private String endCity;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;
    private int travelerCount;
    private int availableCount;
    private TripType tripType;
}
