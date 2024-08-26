package com.melikesivrikaya.notificationservice.service;

import com.melikesivrikaya.notificationservice.exception.ExceptionMessages;
import com.melikesivrikaya.notificationservice.exception.NotificationException;
import com.melikesivrikaya.notificationservice.model.NotificationTemplate;
import com.melikesivrikaya.notificationservice.repository.NotificationTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationTemplateService {

    private final NotificationTemplateRepository notificationTemplateRepository;

    public NotificationTemplate createNotificationTemplate(NotificationTemplate notificationTemplate) {
        try {
            return notificationTemplateRepository.save(notificationTemplate);
        }catch (Exception e){
            throw new NotificationException(ExceptionMessages.NO_SAVE);
        }
    }
}
