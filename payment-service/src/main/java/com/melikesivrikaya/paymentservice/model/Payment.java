package com.melikesivrikaya.paymentservice.model;

import com.melikesivrikaya.paymentservice.model.enums.Rate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Rate rate;

    private int totalPrice;

    private Long userId;
}
