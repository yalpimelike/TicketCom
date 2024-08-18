package com.melikesivrikaya.notificationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class HelloCo {

    @GetMapping
    public String hello() {
        return "Hello Co";
    }
}
