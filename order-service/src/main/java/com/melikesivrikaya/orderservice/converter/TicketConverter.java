package com.melikesivrikaya.orderservice.converter;

import com.melikesivrikaya.orderservice.dto.TicketResponse;
import com.melikesivrikaya.orderservice.model.TicketForOrder;

public class TicketConverter {
    public static TicketResponse toTicketResponse(TicketForOrder ticket) {
        return TicketResponse.builder()
                .number(ticket.getNumber())
                .reserved(ticket.isReserved())
                .price(ticket.getPrice())
                .travellerGender(ticket.getTravellerGender())
                .build();
    }
}
