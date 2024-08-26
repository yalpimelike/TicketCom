package com.melikesivrikaya.tripservice.producer;

import com.melikesivrikaya.tripservice.producer.constants.NotificationConstants;
import com.melikesivrikaya.tripservice.producer.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendNotification(NotificationRequest request) {
        kafkaTemplate.send(NotificationConstants.SEND_EMAIL_TOPIC, request);
    }

}
