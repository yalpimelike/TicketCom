package com.melikesivrikaya.ticketservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String TICKET_NOT_FOUNT = "Ticket not found.";
    public static final String TICKET_RESERVED = "Ticket is reserved.";
    public static final String TICKET_ADDED_BASKET = "Ticket added basket.";
    public static final String MAX_TICKET_EXCEED  = "You have exceeded the maximum number of tickets for the same journey.";
    public static final String MAX_MALE_TRAVELLER = "A maximum of 2 male passengers can be taken in one order.";

}
