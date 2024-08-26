package com.melikesivrikaya.userservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public String handleBlogHubException(UserException userException){
        return userException.getMessage();
    }

}
