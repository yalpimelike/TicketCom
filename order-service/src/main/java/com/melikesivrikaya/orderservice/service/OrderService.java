package com.melikesivrikaya.orderservice.service;

import com.melikesivrikaya.orderservice.exception.ExceptionMessages;
import com.melikesivrikaya.orderservice.exception.OrderException;
import com.melikesivrikaya.orderservice.model.Order;
import com.melikesivrikaya.orderservice.model.TicketForOrder;
import com.melikesivrikaya.orderservice.repository.OrderRepository;
import com.melikesivrikaya.orderservice.repository.TicketForOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final TicketForOrderRepository ticketForOrderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order save(Order order) {
        try {
            return orderRepository.save(order);
        }catch (Exception e){
            throw new OrderException(ExceptionMessages.NO_SAVE);
        }
    }

    public List<TicketForOrder> getTicketsByTripId(Long tripId) {
        try {
            return ticketForOrderRepository.findByTripId(tripId);
        }catch (Exception e){
            throw new OrderException(ExceptionMessages.ERROR_REPO);
        }
    }
}
