package com.melikesivrikaya.userservice.service;

import com.melikesivrikaya.userservice.dto.EmailTemplate;
import com.melikesivrikaya.userservice.dto.SendEmailMessage;
import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.Role;
import com.melikesivrikaya.userservice.producer.RabbitMqProducer;
import com.melikesivrikaya.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RabbitMqProducer rabbitMqProducer;


    public User create(User user) {
        rabbitMqProducer.sendEmail(new SendEmailMessage(user.getEmail(), EmailTemplate.CREATE_USER_TEMPLATE));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
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

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
