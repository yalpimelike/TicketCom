package com.melikesivrikaya.notificationservice.service;

import com.melikesivrikaya.notificationservice.converter.NotificationConverter;
import com.melikesivrikaya.notificationservice.dto.NotificationRequest;
import com.melikesivrikaya.notificationservice.model.NotificationTemplate;
import com.melikesivrikaya.notificationservice.repository.NotificationRepository;
import com.melikesivrikaya.notificationservice.repository.NotificationTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationTemplateRepository notificationTemplateRepository;

    public void sendNotification(NotificationRequest request) {
        NotificationTemplate template = notificationTemplateRepository.getNotificationTemplateByConstants(request.getConstants()).orElse(null);
        if (template == null) {
            template = new NotificationTemplate(request.getConstants(),"Template Oluşturulmamış");
        }
        notificationRepository.save(NotificationConverter.toNotification(request,template.getMessage()));
    }
}
