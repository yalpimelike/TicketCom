package com.melikesivrikaya.tripservice.client.order;

import com.melikesivrikaya.tripservice.dto.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderClientService {

    private final OrderClient orderClient;
    int totalPrice = 0;

    public int totalBuyTicketCount(Long tripId) {
        return orderClient.getTicketsByTripId(tripId).size();
    }

    public int totalBuyTicketPrice(Long tripId) {
        List<TicketResponse> ticketResponses = orderClient.getTicketsByTripId(tripId);
        ticketResponses.forEach(ticketResponse -> totalPrice += ticketResponse.getPrice());
        return totalPrice;
    }
}
