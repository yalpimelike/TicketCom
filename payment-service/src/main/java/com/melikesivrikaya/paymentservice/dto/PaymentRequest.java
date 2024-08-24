package com.melikesivrikaya.paymentservice.dto;

import com.melikesivrikaya.paymentservice.model.enums.Rate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequest {
    private Long tripId,userId;
    private Rate rate;
    private int totalPrice;
}
