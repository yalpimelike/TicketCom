package com.melikesivrikaya.userservice.service;

import com.melikesivrikaya.userservice.dto.UserConstants;
import com.melikesivrikaya.userservice.exception.ExceptionMessages;
import com.melikesivrikaya.userservice.exception.UserException;
import com.melikesivrikaya.userservice.model.User;
import com.melikesivrikaya.userservice.model.enums.Role;
import com.melikesivrikaya.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserCustomerService {
    private final UserRepository userRepository;

    public User getUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            log.error(ExceptionMessages.USER_NOT_FOUNT);
            throw new UserException(ExceptionMessages.USER_NOT_FOUNT);
        }
        return user;
    }

    public User addRole(Long userId, Role role) {

        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            log.error(ExceptionMessages.USER_NOT_FOUNT);
            throw new UserException(ExceptionMessages.USER_NOT_FOUNT);
        }else {
            user.getRoles().add(role);
            userRepository.save(user);
        }
        log.info(UserConstants.USER_ADDED_ROLE + user.toString());
        return user;
    }

    public User deleteRole(Long userId, Role role) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            log.error(ExceptionMessages.USER_NOT_FOUNT);
            throw new UserException(ExceptionMessages.USER_NOT_FOUNT);
        }else {
            user.getRoles().remove(role);
            userRepository.save(user);
        }
        log.info(UserConstants.USER_REMOVE_ROLE + user.toString());
        return user;
    }
}
