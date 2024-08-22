package com.melikesivrikaya.authservice.sevice;
import com.melikesivrikaya.authservice.client.user.UserClientService;
import com.melikesivrikaya.authservice.model.User;
import com.melikesivrikaya.authservice.model.UserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserClientService userClientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userClientService.userByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı");
        }
        return new UserDetail(user);
    }
}
