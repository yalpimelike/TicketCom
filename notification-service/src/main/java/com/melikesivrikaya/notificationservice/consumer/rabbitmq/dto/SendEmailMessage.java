package com.melikesivrikaya.notificationservice.consumer.rabbitmq.dto;

import com.melikesivrikaya.notificationservice.consumer.rabbitmq.dto.enums.EmailTemplate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SendEmailMessage {

    private String to;
    private EmailTemplate emailTemplate;

}
