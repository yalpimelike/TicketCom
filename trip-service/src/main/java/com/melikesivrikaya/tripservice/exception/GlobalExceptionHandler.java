package com.melikesivrikaya.tripservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TripException.class)
    public String handleTripException(TripException userException){
        return userException.getMessage();
    }

}
