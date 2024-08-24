package com.melikesivrikaya.paymentservice.repository;

import com.melikesivrikaya.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
