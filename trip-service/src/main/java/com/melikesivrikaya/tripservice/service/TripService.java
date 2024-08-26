package com.melikesivrikaya.tripservice.service;

import com.melikesivrikaya.tripservice.client.ticket.TicketClientService;
import com.melikesivrikaya.tripservice.dto.CreateTicketListRequest;
import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.model.enums.TripType;
import com.melikesivrikaya.tripservice.producer.KafkaProducer;
import com.melikesivrikaya.tripservice.producer.constants.NotificationConstants;
import com.melikesivrikaya.tripservice.producer.dto.NotificationRequest;
import com.melikesivrikaya.tripservice.producer.enums.NotificationType;
import com.melikesivrikaya.tripservice.repository.TripRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TripService {

    private final TripRepository tripRepository;
    private final KafkaProducer kafkaProducer;
    private final TicketClientService ticketClientService;

    public Trip create(Trip trip,String userId) {
        if (trip.getTripType().equals(TripType.PLANE)){
            trip.setTravelerCount(189);
        } else if (trip.getTripType().equals(TripType.BUS)) {
            trip.setTravelerCount(45);
        }
        Trip savedTrip =  tripRepository.save(trip);
        ticketClientService.createTickets(new CreateTicketListRequest(trip.getId(),trip.getTravelerCount(),trip.getPrice()));
        kafkaProducer.sendNotification(new NotificationRequest(Long.valueOf(userId), NotificationType.EMAIL, NotificationConstants.SEND_EMAIL_TOPIC,trip.toString()));
        return savedTrip;
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public void delete(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    public Trip getTripById(Long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }

    public Trip getAllBuyTickets(Long tripId) {
        return null;
    }

    public void soldTicketCountSubtract(Long tripId, int count) {
        Trip trip = getTripById(tripId);
        trip.setTravelerCount(trip.getTravelerCount() - count);
        tripRepository.save(trip);
    }
}
