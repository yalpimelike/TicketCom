package com.melikesivrikaya.ticketservice.converter;

import com.melikesivrikaya.ticketservice.dto.TicketResponse;
import com.melikesivrikaya.ticketservice.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketConverter {

    public static TicketResponse toResponse(Ticket ticket) {
        return TicketResponse.builder()
                .number(ticket.getNumber())
                .reserved(ticket.isReserved())
                .travellerGender(ticket.getTravellerGender())
                .price(ticket.getPrice())
                .build();
    }
}
