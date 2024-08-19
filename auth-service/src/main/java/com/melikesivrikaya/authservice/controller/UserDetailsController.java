package com.melikesivrikaya.authservice.controller;

import com.melikesivrikaya.authservice.converter.UserDetailsConverter;
import com.melikesivrikaya.authservice.dto.UserDetailsDto;
import com.melikesivrikaya.authservice.sevice.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/userDetails")
public class UserDetailsController {

    private final UserDetailService userDetailService;

    @GetMapping("{email}")
    public UserDetailsDto loadUserByUsername(@PathVariable String email) {
        return UserDetailsConverter.toDto(userDetailService.loadUserByUsername(email));

    }
}
