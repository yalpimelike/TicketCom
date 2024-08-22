package com.melikesivrikaya.tripservice.client.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketClientService {

    private final TicketClient ticketClient;

    public int validateTicket( Long userId, Long tripId){
        return ticketClient.validateTicket(userId, tripId);
    }
}
