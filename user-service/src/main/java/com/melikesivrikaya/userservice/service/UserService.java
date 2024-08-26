package com.melikesivrikaya.userservice.service;

import com.melikesivrikaya.userservice.dto.NotificationRequest;
import com.melikesivrikaya.userservice.dto.UserConstants;
import com.melikesivrikaya.userservice.dto.enums.NotificationType;
import com.melikesivrikaya.userservice.exception.ExceptionMessages;
import com.melikesivrikaya.userservice.exception.UserException;
import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.producer.RabbitMqProducer;
import com.melikesivrikaya.userservice.producer.constants.NotificationConstants;
import com.melikesivrikaya.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RabbitMqProducer rabbitMqProducer;

    public User create(User user) {
        User savedUser = userRepository.save(user);
        if (savedUser != null) {
            rabbitMqProducer.sendNotification(new NotificationRequest(user.getId(), NotificationType.EMAIL, NotificationConstants.CREATE_USER_TEMPLATE,user.toString()));
            log.info(UserConstants.CREATED_USER + user.toString());
            return userRepository.save(user);
        }
        log.error(ExceptionMessages.USER_NOT_FOUNT);
        throw new UserException(ExceptionMessages.USER_NOT_FOUNT);
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return user;
        }
        log.error(ExceptionMessages.USER_NOT_FOUNT);
        throw new UserException(ExceptionMessages.USER_NOT_FOUNT);
    }
}
