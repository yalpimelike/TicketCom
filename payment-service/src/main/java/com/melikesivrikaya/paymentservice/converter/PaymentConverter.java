package com.melikesivrikaya.paymentservice.converter;

import com.melikesivrikaya.paymentservice.dto.PaymentRequest;
import com.melikesivrikaya.paymentservice.model.Payment;

public class PaymentConverter {
    public static Payment toEntity(PaymentRequest paymentRequest) {
        return Payment.builder()
                .rate(paymentRequest.getRate())
                .totalPrice(paymentRequest.getTotalPrice())
                .userId(paymentRequest.getUserId())
                .tripId(paymentRequest.getTripId())
                .build();
    }
}
