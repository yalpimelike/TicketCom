package com.melikesivrikaya.paymentservice.controller;

import com.melikesivrikaya.paymentservice.dto.PaymentRequest;
import com.melikesivrikaya.paymentservice.model.Payment;
import com.melikesivrikaya.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Optional<Payment> paymentTickets(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.paymentTickets(paymentRequest);
    }
}
