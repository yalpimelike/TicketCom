package com.melikesivrikaya.tripservice.model;


import com.melikesivrikaya.tripservice.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private Long id;
    private Long tripId;
    private Long userId; // Bileti alan kişi
    private String travellerName;
    private Gender travellerGender;

    public Ticket(Long userId, Long tripId, String travellerName, Gender travellerGender) {
        this.userId = userId;
        this.tripId = tripId;
        this.travellerName = travellerName;
        this.travellerGender = travellerGender;
    }
}
