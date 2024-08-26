package com.melikesivrikaya.userservice.service;

import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.Role;
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

    public User addRole(Long userId, Role role) {

        // TODO aynı emailde farklı kullanıcı varmı kontrol et

        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            throw new RuntimeException("User not found");
        }else {
            user.getRoles().add(role);
            userRepository.save(user);
        }
        return user;
    }

    public User deleteRole(Long userId, Role role) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            throw new RuntimeException("User not found");
        }else {
            user.getRoles().remove(role);
            userRepository.save(user);
        }
        return user;
    }
}
