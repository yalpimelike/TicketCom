package com.melikesivrikaya.gatewayservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {
    @GetMapping
    public String hi() {
        return "hi";
    }
}
