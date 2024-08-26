package com.melikesivrikaya.orderservice.dto;

import com.melikesivrikaya.orderservice.model.enums.Gender;
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
