package com.melikesivrikaya.tripservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketClientService {
    private final TicketClient ticketClient;
    public void createTickets( int ticketSize, Long tripId){
        ticketClient.createTickets(ticketSize, tripId);
    }
}
