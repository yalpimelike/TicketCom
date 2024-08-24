package com.melikesivrikaya.orderservice.model;

import com.melikesivrikaya.orderservice.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class TicketForOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long tripId;
    private int number;
    private Long userId;
    private boolean reserved;
    private Boolean isPayment;
    private Gender travellerGender;
    private String startCity;
    private String endCity;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;

}
