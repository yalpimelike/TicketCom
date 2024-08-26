package com.melikesivrikaya.tripservice.client.order;

import com.melikesivrikaya.tripservice.dto.TicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "order-service" , url = "localhost:1018/api/v1/orders")
public interface OrderClient {

    @GetMapping("/{tripId}")
    List<TicketResponse> getTicketsByTripId(@PathVariable Long tripId);
}
