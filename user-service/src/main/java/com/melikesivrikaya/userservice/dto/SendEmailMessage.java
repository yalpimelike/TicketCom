package com.melikesivrikaya.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendEmailMessage {
    private String to;
    private EmailTemplate emailTemplate;
}
