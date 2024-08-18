package com.melikesivrikaya.authservice.controller;

import com.melikesivrikaya.authservice.dto.request.UserLoginRequest;
import com.melikesivrikaya.authservice.dto.request.UserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public void register(@RequestBody UserSaveRequest request) {
        System.out.println("kod gelie");
    }

    @GetMapping
    public void hi() {
        System.out.println("kod gelie");
    }

}