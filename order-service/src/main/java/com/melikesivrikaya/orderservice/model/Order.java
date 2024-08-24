package com.melikesivrikaya.orderservice.model;

import com.melikesivrikaya.orderservice.model.enums.Rate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    @OneToMany
    private List<TicketForOrder> tickets;
    private int totalPrice;
    private Rate rate;
}
