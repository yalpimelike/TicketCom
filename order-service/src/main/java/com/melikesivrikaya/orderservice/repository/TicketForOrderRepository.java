package com.melikesivrikaya.orderservice.repository;

import com.melikesivrikaya.orderservice.model.TicketForOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketForOrderRepository extends JpaRepository<TicketForOrder, Long> {
    List<TicketForOrder> findByTripId(Long tripId);
}
