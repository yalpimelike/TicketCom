package com.melikesivrikaya.authservice.client.user;

import com.melikesivrikaya.authservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserClientService {

    private final UserClient userClient;

    public User createUser(User user) {
        return userClient.create(user);
    }

    public boolean existsByUsername(String username) {
        return userClient.findByUsername(username) != null;
    }

    public User userByUsername(String username) {
        return userClient.findByUsername(username);
    }
}
