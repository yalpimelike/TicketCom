package com.melikesivrikaya.searchservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SearchException.class)
    public String handleSearchException(SearchException searchException){
        return searchException.getMessage();
    }

}
