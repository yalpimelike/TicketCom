package com.melikesivrikaya.notificationservice.repository;

import com.melikesivrikaya.notificationservice.model.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, String> {

    Optional<NotificationTemplate> getNotificationTemplateByConstants(String id);
}
