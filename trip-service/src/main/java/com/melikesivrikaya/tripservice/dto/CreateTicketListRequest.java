package com.melikesivrikaya.tripservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateTicketListRequest {
    private Long tripId;
    private int ticketSize;
    private int price;

}
