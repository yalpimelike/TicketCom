package com.melikesivrikaya.gatewayservice.client;

import com.melikesivrikaya.gatewayservice.dto.UserDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthClientService {

    private final AuthClient authClient;

    public UserDetailsDto loadUserByUsername(String username) {
         return authClient.loadUserByUsername(username);
    }
}
