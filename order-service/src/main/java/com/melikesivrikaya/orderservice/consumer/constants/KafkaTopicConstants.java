package com.melikesivrikaya.orderservice.consumer.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KafkaTopicConstants {
    public static final String ORDER_SAVE_TOPIC = "order_save_topic";
}
