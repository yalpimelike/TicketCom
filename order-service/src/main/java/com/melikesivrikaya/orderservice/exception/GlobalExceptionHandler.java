package com.melikesivrikaya.orderservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public String handleOrderException(OrderException orderException){
        return orderException.getMessage();
    }

}
