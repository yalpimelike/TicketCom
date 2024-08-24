package com.melikesivrikaya.notificationservice.consumer.kafka;

import com.melikesivrikaya.notificationservice.consumer.kafka.constants.KafkaTopicConstants;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    @KafkaListener(topics = KafkaTopicConstants.SEND_EMAIL_TOPIC, groupId = "${kafka.group-id}")
    public void listen(Order order) {
        log.info("Received Messasge: {}", order.toString());
    }

}
