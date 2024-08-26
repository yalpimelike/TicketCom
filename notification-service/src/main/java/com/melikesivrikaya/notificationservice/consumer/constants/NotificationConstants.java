package com.melikesivrikaya.notificationservice.consumer.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NotificationConstants {
    public static final String  CREATE_USER_TEMPLATE = "CREATE_USER_TEMPLATE";
    public static final String  SEND_EMAIL_TOPIC = "SEND_EMAIL_TOPIC";
    public static final String  ORDER_SAVE_TOPIC = "ORDER_SAVE_TOPIC";
    public static final String  SEND_SMS_TOPIC = "SEND_SMS_TOPIC";
}
