package com.melikesivrikaya.notificationservice.consumer.kafka;

import com.melikesivrikaya.notificationservice.consumer.constants.NotificationConstants;
import com.melikesivrikaya.notificationservice.dto.NotificationRequest;
import com.melikesivrikaya.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = NotificationConstants.SEND_EMAIL_TOPIC, groupId = "${kafka.group-id}")
    public void listenEmail(NotificationRequest request) {
        log.info("Received Messasge: {}", request.getObject().toString());
        notificationService.sendNotification(request);
    }

    @KafkaListener(topics = NotificationConstants.SEND_SMS_TOPIC, groupId = "${kafka.group-id}")
    public void listenSms(NotificationRequest request) {
        log.info("Received Messasge: {}", request.getObject().toString());
        notificationService.sendNotification(request);
    }
}
