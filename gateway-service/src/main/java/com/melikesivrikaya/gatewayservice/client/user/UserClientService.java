package com.melikesivrikaya.gatewayservice.client.user;

import com.melikesivrikaya.gatewayservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserClientService {

    private final UserClient userClient;

    public User userByUsername(String username) {
        return userClient.findByUsername(username);
    }
}
