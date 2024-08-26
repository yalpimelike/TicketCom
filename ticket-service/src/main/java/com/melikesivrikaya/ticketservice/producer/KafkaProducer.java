package com.melikesivrikaya.ticketservice.producer;

import com.melikesivrikaya.ticketservice.dto.Order;
import com.melikesivrikaya.ticketservice.producer.constants.KafkaTopicConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrder(Order order) {
        kafkaTemplate.send(KafkaTopicConstants.ORDER_SAVE_TOPIC, order);
    }

    public void sendEmail(Order order) {
        kafkaTemplate.send(KafkaTopicConstants.SEND_EMAIL_TOPIC, order);
    }

    public void senSms(Order order) {
        kafkaTemplate.send(KafkaTopicConstants.SEND_SMS_TOPIC, order);
    }
}
