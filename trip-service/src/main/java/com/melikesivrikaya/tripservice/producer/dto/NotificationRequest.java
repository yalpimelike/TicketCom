package com.melikesivrikaya.tripservice.producer.dto;

import com.melikesivrikaya.tripservice.producer.constants.NotificationConstants;
import com.melikesivrikaya.tripservice.producer.enums.NotificationType;
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

    public NotificationRequest(Long userId, NotificationType type, String constants) {
        this.userId = userId;
        this.type = type;
        this.constants = constants;
    }
}
