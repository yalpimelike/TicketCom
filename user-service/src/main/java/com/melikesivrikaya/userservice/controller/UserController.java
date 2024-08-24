package com.melikesivrikaya.userservice.controller;

import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.Role;
import com.melikesivrikaya.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    private User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{userId}/{role}")
    public User addRole(@PathVariable Long userId,@PathVariable Role role) {
        return userService.addRole(userId,role);
    }

    @DeleteMapping("/{userId}/{role}")
    public User deleteRole(@PathVariable Long userId,@PathVariable Role role) {
        return userService.deleteRole(userId,role);
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
