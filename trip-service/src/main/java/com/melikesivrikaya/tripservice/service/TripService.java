package com.melikesivrikaya.tripservice.service;

import com.melikesivrikaya.tripservice.client.ticket.TicketClientService;
import com.melikesivrikaya.tripservice.dto.CreateTicketListRequest;
import com.melikesivrikaya.tripservice.dto.TripConstants;
import com.melikesivrikaya.tripservice.exception.ExceptionMessages;
import com.melikesivrikaya.tripservice.exception.TripException;
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
            trip.setTravelerCount(TripConstants.PLANE_TRAVELLER_COUNT);
        } else if (trip.getTripType().equals(TripType.BUS)) {
            trip.setTravelerCount(TripConstants.BUS_TRAVELLER_COUNT);
        }
        Trip savedTrip =  tripRepository.save(trip);
        ticketClientService.createTickets(new CreateTicketListRequest(trip.getId(),trip.getTravelerCount(),trip.getPrice()));
        kafkaProducer.sendNotification(new NotificationRequest(Long.valueOf(userId), NotificationType.EMAIL, NotificationConstants.SEND_EMAIL_TOPIC,trip.toString()));
        log.info(TripConstants.CREATED_TRIP + savedTrip.toString());
        return savedTrip;
    }

    public void delete(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    public Trip getTripById(Long tripId) {
        Trip trip =  tripRepository.findById(tripId).orElse(null);
        if (trip == null) {
            log.error(ExceptionMessages.TRIP_NOT_FOUND);
            throw new TripException(ExceptionMessages.TRIP_NOT_FOUND);
        }
        return trip;
    }

    public void soldTicketCountSubtract(Long tripId, int count) {
        Trip trip = getTripById(tripId);
        if (trip == null){
            log.error(ExceptionMessages.TRIP_NOT_FOUND);
            throw new TripException(ExceptionMessages.TRIP_NOT_FOUND);
        }
        trip.setTravelerCount(trip.getTravelerCount() - count);
        tripRepository.save(trip);
        log.info(TripConstants.CREATED_TRIP + trip.toString());
    }
}
