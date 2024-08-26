package com.melikesivrikaya.ticketservice.dto;

import com.melikesivrikaya.ticketservice.dto.enums.Gender;
import com.melikesivrikaya.ticketservice.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TicketForOrder {
    private Long id;
    private Long tripId;
    private int number;
    private Long userId;
    private boolean reserved;
    private Boolean isPayment;
    private Gender travellerGender;
    private String startCity;
    private String endCity;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;

    public TicketForOrder(Ticket ticket, Trip trip) {
        this.tripId = ticket.getTripId();
        this.number = ticket.getNumber();
        this.userId = ticket.getUserId();
        this.reserved = ticket.isReserved();
        this.isPayment = ticket.getIsPayment();
        this.travellerGender = ticket.getTravellerGender();
        this.startCity = trip.getStartCity();
        this.endCity = trip.getEndCity();
        this.startDate = trip.getStartDate();
        this.endDate = trip.getEndDate();
        this.price = ticket.getPrice();
    }
}
