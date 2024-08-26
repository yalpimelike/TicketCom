package com.melikesivrikaya.userservice.dto;

import com.melikesivrikaya.userservice.dto.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationRequest {
    private Long userId;
    private NotificationType type;
    private String constants;

    private String object;
}
