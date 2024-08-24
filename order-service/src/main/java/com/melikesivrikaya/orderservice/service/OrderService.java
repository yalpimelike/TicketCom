package com.melikesivrikaya.orderservice.service;

import com.melikesivrikaya.orderservice.model.Order;
import com.melikesivrikaya.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
