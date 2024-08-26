package com.melikesivrikaya.notificationservice.model;

import com.melikesivrikaya.notificationservice.model.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private String constants;
    private String message;
    private Long userId;

    private String object;

}
