package com.melikesivrikaya.notificationservice.repository;

import com.melikesivrikaya.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
