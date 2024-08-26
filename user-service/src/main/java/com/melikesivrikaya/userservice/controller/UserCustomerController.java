package com.melikesivrikaya.userservice.controller;

import com.melikesivrikaya.userservice.converter.UserConverter;
import com.melikesivrikaya.userservice.dto.UserResponse;
import com.melikesivrikaya.userservice.service.UserCustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users/customer")
public class UserCustomerController {

    private final UserCustomerService userCustomerService;

    @GetMapping("{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return UserConverter.toResponse(userCustomerService.getUser(userId));
    }

}
