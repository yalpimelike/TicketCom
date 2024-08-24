package com.melikesivrikaya.orderservice.controller;

import com.melikesivrikaya.orderservice.model.Order;
import com.melikesivrikaya.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private  final OrderService orderService;
    @GetMapping
    public List<Order> getOrders() {
        return orderService.findAll();
    }
}
