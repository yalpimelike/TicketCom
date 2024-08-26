package com.melikesivrikaya.orderservice.controller;

import com.melikesivrikaya.orderservice.converter.TicketConverter;
import com.melikesivrikaya.orderservice.dto.TicketResponse;
import com.melikesivrikaya.orderservice.model.Order;
import com.melikesivrikaya.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{tripId}")
    public List<TicketResponse> getTicketsByTripId(@PathVariable Long tripId) {
        return orderService.getTicketsByTripId(tripId).stream().map(TicketConverter::toTicketResponse).toList();
    }
}
