package com.melikesivrikaya.authservice.sevice;
import com.melikesivrikaya.authservice.client.user.UserClientService;
import com.melikesivrikaya.authservice.exception.ExceptionMessages;
import com.melikesivrikaya.authservice.model.User;
import com.melikesivrikaya.authservice.model.UserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    private final UserClientService userClientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userClientService.userByUsername(username);
        if (user == null) {
            log.error(ExceptionMessages.USER_NOT_FOUNT);
            throw new UsernameNotFoundException(ExceptionMessages.USER_NOT_FOUNT);
        }
        return new UserDetail(user);
    }
}
