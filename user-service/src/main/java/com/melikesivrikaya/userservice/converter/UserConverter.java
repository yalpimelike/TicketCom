package com.melikesivrikaya.userservice.converter;

import com.melikesivrikaya.userservice.dto.UserResponse;
import com.melikesivrikaya.userservice.model.User;

public class UserConverter {

    public static UserResponse toResponse(final User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .email(user.getEmail())
                .build();
    }
}
