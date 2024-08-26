package com.melikesivrikaya.notificationservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotificationException.class)
    public String handleNotificationException(NotificationException orderException){
        return orderException.getMessage();
    }

}
