package com.melikesivrikaya.authservice.controller;

import com.melikesivrikaya.authservice.converter.UserConverter;
import com.melikesivrikaya.authservice.dto.UserResponse;
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
    public UserResponse register(@RequestBody UserSaveRequest request) {
        return UserConverter.toResponse(authService.register(request));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        return authService.login(request);
    }
}