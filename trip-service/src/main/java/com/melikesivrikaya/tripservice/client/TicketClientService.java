package com.melikesivrikaya.tripservice.client;

import com.melikesivrikaya.tripservice.dto.CreateTicketListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketClientService {
    private final TicketClient ticketClient;
    public void createTickets(CreateTicketListRequest request){
        ticketClient.createTickets(request);
    }
}
