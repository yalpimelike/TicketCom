package com.melikesivrikaya.authservice.sevice;

import com.melikesivrikaya.authservice.client.user.UserClientService;
import com.melikesivrikaya.authservice.dto.AuthConstants;
import com.melikesivrikaya.authservice.dto.request.UserLoginRequest;
import com.melikesivrikaya.authservice.dto.request.UserSaveRequest;
import com.melikesivrikaya.authservice.exception.AuthException;
import com.melikesivrikaya.authservice.exception.ExceptionMessages;
import com.melikesivrikaya.authservice.model.User;
import com.melikesivrikaya.authservice.model.enums.Role;
import com.melikesivrikaya.authservice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserClientService userClientService;
    private final JwtUtil jwtUtil;

    public User register(UserSaveRequest request) {

        boolean isVariableUser = userClientService.existsByUsername(request.getUsername());

       if (isVariableUser) {
           log.error(ExceptionMessages.USER_CURRENT);
           throw new AuthException(ExceptionMessages.USER_CURRENT);
       }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .userType(request.getUserType())
                .phone(request.getPhone())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .roles(Set.of(Role.USER))
                .build();

       log.info(AuthConstants.CREATED_USER + user.toString());
        return userClientService.createUser(user);
    }

    public String login(UserLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = userClientService.userByUsername(request.getUsername());
        return jwtUtil.generateToken(user);
    }

}