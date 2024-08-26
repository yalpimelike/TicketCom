package com.melikesivrikaya.ticketservice.producer;

import com.melikesivrikaya.ticketservice.dto.Order;
import com.melikesivrikaya.ticketservice.producer.constants.NotificationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendNotification(Order order) {
        kafkaTemplate.send(NotificationConstants.ORDER_SAVE_TOPIC, order);
    }
}
