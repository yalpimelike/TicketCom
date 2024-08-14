package com.melikesivrikaya.ticketservice.controller;

import com.melikesivrikaya.ticketservice.model.User;
import com.melikesivrikaya.ticketservice.model.enums.Role;
import com.melikesivrikaya.ticketservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    private User create(@RequestBody  User user) {
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
}
