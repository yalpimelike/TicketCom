package com.melikesivrikaya.indexservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IndexException.class)
    public String handleOrderException(IndexException orderException){
        return orderException.getMessage();
    }

}
