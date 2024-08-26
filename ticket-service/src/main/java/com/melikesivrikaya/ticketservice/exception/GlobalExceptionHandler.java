package com.melikesivrikaya.ticketservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TicketException.class)
    public String handleBlogHubException(TicketException ticketException){
        return ticketException.getMessage();
    }

}
