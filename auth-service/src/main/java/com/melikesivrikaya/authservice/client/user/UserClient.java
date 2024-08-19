package com.melikesivrikaya.authservice.client.user;

import com.melikesivrikaya.authservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "user-service", url = "localhost:1012/api/v1/users/")
public interface UserClient {

    @GetMapping
    List<User> getAll();

    @PostMapping
    User create(@RequestBody User user);

    @GetMapping("{email}")
    User findByEmail(@PathVariable String email);
}
