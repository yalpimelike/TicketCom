package com.melikesivrikaya.ticketservice.dto;

import com.melikesivrikaya.ticketservice.dto.enums.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest {
    private Long userId;
    private Rate rate;
    private int totalPrice;
}
