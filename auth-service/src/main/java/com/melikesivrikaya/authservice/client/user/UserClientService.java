package com.melikesivrikaya.authservice.client.user;

import com.melikesivrikaya.authservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserClientService {

    private final UserClient userClient;

    public List<User> getUsers() {
        System.out.println("UserClient Service e geldi");
        return userClient.getAll();
    }

    public User createUser(User user) {
        return userClient.create(user);
    }

    public boolean existsByEmail(String email) {
        return userClient.findByEmail(email) != null;
    }

    public User userByEmail(String email) {
        return userClient.findByEmail(email);
    }
}
