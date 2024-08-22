package com.melikesivrikaya.tripservice.dto;

import com.melikesivrikaya.tripservice.model.enums.Gender;
import lombok.Data;

@Data
public class TicketAddBasketRequest {
    private Long tripId,userId;
    private String travellerName;
    private Gender travellerGender;
}
