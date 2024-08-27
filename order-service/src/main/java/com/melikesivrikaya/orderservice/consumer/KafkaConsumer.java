package com.melikesivrikaya.orderservice.consumer;

import com.melikesivrikaya.orderservice.consumer.constants.KafkaTopicConstants;
import com.melikesivrikaya.orderservice.model.Order;
import com.melikesivrikaya.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = KafkaTopicConstants.ORDER_SAVE_TOPIC, groupId = "${kafka.group-id}")
    public void listen(Order order) {
        log.info("Received Messasge: {}", order);
        orderService.save(order);
    }

}
