package com.melikesivrikaya.notificationservice.consumer.rabbitmq;

import com.melikesivrikaya.notificationservice.consumer.rabbitmq.dto.SendEmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailConsumer {

    @RabbitListener(queues = "${rabbitmq.notification.queue}")
    public void listenEmail(SendEmailMessage emailMessage) {
        log.info("emailMessage: {}", emailMessage);
    }
}
