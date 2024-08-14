package com.melikesivrikaya.notificationservice.consumer;

import com.melikesivrikaya.notificationservice.consumer.dto.SendEmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailConsumer {

    @RabbitListener(queues = "${rabbitmq.email.queue}")
    public void listenEmail(SendEmailMessage emailMessage) {
        log.info("emailMessage: {}", emailMessage);
    }
}
