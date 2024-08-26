package com.melikesivrikaya.notificationservice.dto;

import com.melikesivrikaya.notificationservice.model.enums.NotificationType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotificationRequest {

    private Long userId;
    private NotificationType type;
    private String constants;

    private String object;

}
