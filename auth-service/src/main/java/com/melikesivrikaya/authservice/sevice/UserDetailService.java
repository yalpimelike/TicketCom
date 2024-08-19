package com.melikesivrikaya.authservice.sevice;

import com.melikesivrikaya.authservice.client.user.UserClientService;
import com.melikesivrikaya.authservice.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserClientService userClientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userDetails = userClientService.userByEmail(email);
        if (userDetails == null) {
            throw new UsernameNotFoundException(email);
        }
        return userDetails;
    }

}
