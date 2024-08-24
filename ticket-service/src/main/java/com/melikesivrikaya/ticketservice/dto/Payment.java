package com.melikesivrikaya.ticketservice.dto;

import com.melikesivrikaya.ticketservice.dto.enums.Rate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private Rate rate;
    private int totalPrice;
    private Long tripId,userId;
}
