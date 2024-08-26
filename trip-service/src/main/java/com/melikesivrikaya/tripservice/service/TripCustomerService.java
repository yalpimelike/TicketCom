package com.melikesivrikaya.tripservice.service;

import com.melikesivrikaya.tripservice.dto.CreateTicketListRequest;
import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.model.enums.TripType;
import com.melikesivrikaya.tripservice.repository.TripRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TripCustomerService {

    private final TripRepository tripRepository;

}
