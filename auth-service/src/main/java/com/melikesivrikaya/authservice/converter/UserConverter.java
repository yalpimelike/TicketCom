package com.melikesivrikaya.authservice.converter;


import com.melikesivrikaya.authservice.dto.UserResponse;
import com.melikesivrikaya.authservice.model.User;

public class UserConverter {

    public static UserResponse toResponse(final User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .email(user.getEmail())
                .build();
    }
}
