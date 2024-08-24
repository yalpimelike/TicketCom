package com.melikesivrikaya.ticketservice.dto;

import com.melikesivrikaya.ticketservice.model.Ticket;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class CreateOrderRequest {
    private Long userId;
    private LocalDateTime paymentDate;
    private final Map<Long, List<Ticket>> ticketList = new HashMap<>();
}
