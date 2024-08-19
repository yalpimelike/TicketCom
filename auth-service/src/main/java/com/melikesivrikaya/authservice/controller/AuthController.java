package com.melikesivrikaya.authservice.controller;

import com.melikesivrikaya.authservice.dto.request.UserLoginRequest;
import com.melikesivrikaya.authservice.dto.request.UserSaveRequest;
import com.melikesivrikaya.authservice.model.User;
import com.melikesivrikaya.authservice.sevice.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody UserSaveRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        return authService.login(request);
    }

    @GetMapping
    public void hi() {
        System.out.println("kod gelie222");
    }

}