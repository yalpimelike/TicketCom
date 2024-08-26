package com.melikesivrikaya.gatewayservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String USER_NOT_FOUNT = "User not found.";
    public static final String USER_CURRENT = "There is already a user with this username.";
}
