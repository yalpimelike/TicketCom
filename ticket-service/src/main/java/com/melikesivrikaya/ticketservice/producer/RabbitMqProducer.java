package com.melikesivrikaya.ticketservice.producer;

import com.melikesivrikaya.ticketservice.config.RabbitMqConfig;
import com.melikesivrikaya.ticketservice.dto.SendEmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqProducer {

    private final AmqpTemplate rabbitTemplate;

    private final RabbitMqConfig rabbitMQConfig;

    public void sendEmail(SendEmailMessage sendEmailMessage) {
        rabbitTemplate.convertAndSend(rabbitMQConfig.getExchange(), rabbitMQConfig.getRoutingkey(), sendEmailMessage);

        log.info("Message kuyruğa gönderildi. kuyruk:{}, message: {}", rabbitMQConfig.getQueueName(), sendEmailMessage);

    }

}
