package com.melikesivrikaya.notificationservice.consumer.dto;

import com.melikesivrikaya.notificationservice.consumer.dto.enums.EmailTemplate;
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
