package com.melikesivrikaya.ticketservice.client.payment;

import com.melikesivrikaya.ticketservice.dto.Payment;
import com.melikesivrikaya.ticketservice.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(value = "payment-service" , url = "localhost:1015/api/v1/payments")
public interface PaymentClient {

    @PostMapping
    Optional<Payment> paymentTickets(@RequestBody PaymentRequest paymentRequest);
}
