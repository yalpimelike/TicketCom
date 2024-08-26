package com.melikesivrikaya.authservice.client.user;

import com.melikesivrikaya.authservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "user-service", url = "localhost:1012/api/v1/users/")
public interface UserClient {

    @PostMapping
    User create(@RequestBody User user);

    @GetMapping("{username}")
    User findByUsername(@PathVariable String username);
}
