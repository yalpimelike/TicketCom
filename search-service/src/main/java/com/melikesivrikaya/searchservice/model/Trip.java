package com.melikesivrikaya.searchservice.model;

import com.melikesivrikaya.searchservice.model.enums.TripType;
import lombok.*;

import java.time.LocalDate;

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
    private int occupant;
    private TripType tripType;
}
