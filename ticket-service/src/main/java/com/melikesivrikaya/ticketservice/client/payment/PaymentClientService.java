package com.melikesivrikaya.ticketservice.client.payment;

import com.melikesivrikaya.ticketservice.dto.Payment;
import com.melikesivrikaya.ticketservice.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentClientService {

    private final PaymentClient paymentClient;

    public Optional<Payment> paymentTickets(@RequestBody PaymentRequest paymentRequest){
        return paymentClient.paymentTickets(paymentRequest);
    }
}
