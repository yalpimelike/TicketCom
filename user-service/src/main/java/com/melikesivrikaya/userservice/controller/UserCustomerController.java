package com.melikesivrikaya.userservice.controller;

import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.Role;
import com.melikesivrikaya.userservice.service.UserCustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users/customer")
public class UserCustomerController {

    private final UserCustomerService userCustomerService;

    @GetMapping("{userId}")
    public User getUser(@PathVariable Long userId) {
        return userCustomerService.getUser(userId);
    }

    @GetMapping("/{userId}/{role}")
    public User addRole(@PathVariable Long userId, @PathVariable Role role) {
        return userCustomerService.addRole(userId,role);
    }

    @DeleteMapping("/{userId}/{role}")
    public User deleteRole(@PathVariable Long userId,@PathVariable Role role) {
        return userCustomerService.deleteRole(userId,role);
    }
}
