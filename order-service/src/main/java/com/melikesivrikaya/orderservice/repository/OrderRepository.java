package com.melikesivrikaya.orderservice.repository;

import com.melikesivrikaya.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
