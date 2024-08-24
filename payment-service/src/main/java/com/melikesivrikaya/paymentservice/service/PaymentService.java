package com.melikesivrikaya.paymentservice.service;

import com.melikesivrikaya.paymentservice.converter.PaymentConverter;
import com.melikesivrikaya.paymentservice.dto.PaymentRequest;
import com.melikesivrikaya.paymentservice.model.Payment;
import com.melikesivrikaya.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Optional<Payment> paymentTickets(@RequestBody PaymentRequest paymentRequest) {
        return Optional.of(paymentRepository.save(PaymentConverter.toEntity(paymentRequest)));
    }

}
