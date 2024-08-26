package com.melikesivrikaya.authservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public String handleBlogHubException(AuthException authException){
        return authException.getMessage();
    }

}
