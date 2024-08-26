package com.melikesivrikaya.notificationservice.converter;

import com.melikesivrikaya.notificationservice.dto.NotificationRequest;
import com.melikesivrikaya.notificationservice.model.Notification;

public class NotificationConverter {
        public static Notification toNotification(NotificationRequest request,String message) {
            return Notification.builder()
                    .type(request.getType())
                    .constants(request.getConstants())
                    .message(message)
                    .userId(request.getUserId())
                    .object(request.getObject())
                    .build();
        }
}
