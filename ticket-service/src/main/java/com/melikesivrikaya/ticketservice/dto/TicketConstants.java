package com.melikesivrikaya.ticketservice.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketConstants {
    public static final int CORPORATE_USER_MAX_TICKET = 40;
    public static final int CORPORATE_USER_MAX_MALE_TICKET = 40;
    public static final int INDIVIDUAL_USER_MAX_TICKET = 5;
    public static final String ADDED_TICKET_TO_BASKET = "Ticket added to basked.";
    public static final String APPROVAL_BASKET = "Basket approved.";
    public static final String VALIDATE_BASKET = "Validate basket.";
}
