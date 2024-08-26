package com.melikesivrikaya.userservice.service;

import com.melikesivrikaya.userservice.dto.NotificationRequest;
import com.melikesivrikaya.userservice.dto.enums.NotificationType;
import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.producer.RabbitMqProducer;
import com.melikesivrikaya.userservice.producer.constants.NotificationConstants;
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
        rabbitMqProducer.sendNotification(new NotificationRequest(user.getId(), NotificationType.EMAIL, NotificationConstants.CREATE_USER_TEMPLATE,user.toString()));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
