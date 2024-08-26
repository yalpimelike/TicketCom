package com.melikesivrikaya.notificationservice.service;

import com.melikesivrikaya.notificationservice.model.NotificationTemplate;
import com.melikesivrikaya.notificationservice.repository.NotificationTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationTemplateService {

    private final NotificationTemplateRepository notificationTemplateRepository;

    public NotificationTemplate createNotificationTemplate(NotificationTemplate notificationTemplate) {
        return notificationTemplateRepository.save(notificationTemplate);
    }
}
