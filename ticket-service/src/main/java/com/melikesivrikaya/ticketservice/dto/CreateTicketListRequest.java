package com.melikesivrikaya.ticketservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateTicketListRequest {
    private Long tripId;
    private int ticketSize;
    private int price;
}
