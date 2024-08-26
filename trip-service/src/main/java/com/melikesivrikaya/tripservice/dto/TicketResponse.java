package com.melikesivrikaya.tripservice.dto;

import com.melikesivrikaya.tripservice.dto.enums.Gender;
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
