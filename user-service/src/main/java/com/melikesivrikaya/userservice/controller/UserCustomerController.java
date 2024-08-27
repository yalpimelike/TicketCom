package com.melikesivrikaya.userservice.controller;

import com.melikesivrikaya.userservice.converter.UserConverter;
import com.melikesivrikaya.userservice.dto.UserResponse;
import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.Role;
import com.melikesivrikaya.userservice.service.UserCustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users/customer")
public class UserCustomerController {

    private final UserCustomerService userCustomerService;

    @GetMapping("{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        User user =  userCustomerService.getUser(userId);
        return UserConverter.toResponse(user);
    }

    @GetMapping
    public String hi(){
        return "hi";
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
