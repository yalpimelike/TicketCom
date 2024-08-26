package com.melikesivrikaya.notificationservice.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification-temlates")
public class NotificationTemplate {

    @Id
    private String constants;
    private String message;

}
