package com.melikesivrikaya.indexservice.consumer;

import com.melikesivrikaya.indexservice.consumer.constants.KafkaTopicConstants;
import com.melikesivrikaya.indexservice.converter.TripConverter;
import com.melikesivrikaya.indexservice.model.Trip;
import com.melikesivrikaya.indexservice.model.TripDocument;
import com.melikesivrikaya.indexservice.repository.TripDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final TripDocumentRepository tripDocumentRepository;

    @KafkaListener(topics = KafkaTopicConstants.TRIP_INDEX_TOPIC, groupId = "${kafka.group-id}")
    public void listen(Trip trip) {
        log.info("Received Messasge: {}", trip);
        TripDocument blogDocument = tripDocumentRepository.save(TripConverter.toDocument(trip));
        log.info(blogDocument.getEndCity());
    }

}