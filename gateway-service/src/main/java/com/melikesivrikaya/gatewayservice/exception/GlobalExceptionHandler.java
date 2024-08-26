package com.melikesivrikaya.gatewayservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public String handleAuthException(AuthException authException){
        return authException.getMessage();
    }

}
