package com.melikesivrikaya.notificationservice.consumer.rabbitmq;

import com.melikesivrikaya.notificationservice.dto.NotificationRequest;
import com.melikesivrikaya.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMqlConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.notification.queue}")
    public void listenEmail(NotificationRequest request) {
        log.info(request.toString());
        notificationService.sendNotification(request);
    }
}
