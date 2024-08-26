package com.melikesivrikaya.notificationservice.consumer.kafka.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KafkaTopicConstants {
    public static final String ORDER_SAVE_TOPIC = "order_save_topic";
    public static final String SEND_EMAIL_TOPIC = "send_email_topic";
    public static final String SEND_SMS_TOPIC = "send_sms_topic";
}
