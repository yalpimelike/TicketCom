package com.melikesivrikaya.gatewayservice.client;

import com.melikesivrikaya.gatewayservice.dto.UserDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "auth-service", url = "localhost:1013/api/v1/userDetails")
public interface AuthClient {

    @GetMapping("{email}")
    UserDetailsDto loadUserByUsername(@PathVariable String email);
}
