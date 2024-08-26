package com.melikesivrikaya.notificationservice.controller;


import com.melikesivrikaya.notificationservice.model.NotificationTemplate;
import com.melikesivrikaya.notificationservice.service.NotificationTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification-template")
public class NotificationTemplateController {

    private final NotificationTemplateService notificationTemplateService;

    @PostMapping
    public NotificationTemplate createNotificationTemplate(@RequestBody NotificationTemplate notificationTemplate) {
        return notificationTemplateService.createNotificationTemplate(notificationTemplate);
    }
    @GetMapping
    public String hi(){
       return "hi";
    }
}
