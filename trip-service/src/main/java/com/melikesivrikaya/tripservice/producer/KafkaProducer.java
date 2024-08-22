package com.melikesivrikaya.tripservice.producer;

import com.melikesivrikaya.tripservice.model.Trip;
import com.melikesivrikaya.tripservice.producer.constants.KafkaTopicConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendTrip(Trip trip) {
        log.info("Trip gönderildi: {}", trip.getStartCity());
        kafkaTemplate.send(KafkaTopicConstants.TRIP_INDEX_TOPIC, trip);
    }

}
