package com.melikesivrikaya.ticketservice.model;

import com.melikesivrikaya.ticketservice.dto.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long tripId;
    private int number;
    private Long userId;
    private boolean reserved;
    private Boolean isPayment;
    private Gender travellerGender;
    private int price;

    public Ticket(Long tripId, int number, boolean reserved, Boolean isPayment,int price) {
        this.tripId = tripId;
        this.number = number;
        this.reserved = reserved;
        this.isPayment = isPayment;
    }
}
