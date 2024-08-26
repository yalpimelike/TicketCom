package com.melikesivrikaya.ticketservice.dto;

import com.melikesivrikaya.ticketservice.dto.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
@AllArgsConstructor
public class TicketResponse {

    private int number;
    private boolean reserved;
    private Gender travellerGender;
    private int price;
}
