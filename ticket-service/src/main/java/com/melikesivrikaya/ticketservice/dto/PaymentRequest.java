package com.melikesivrikaya.ticketservice.dto;

import com.melikesivrikaya.ticketservice.dto.enums.Rate;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long tripId,userId;
    private Rate rate;
    private int totalPrice;
}
