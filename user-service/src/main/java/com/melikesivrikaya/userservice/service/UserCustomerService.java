package com.melikesivrikaya.userservice.service;

import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCustomerService {
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
