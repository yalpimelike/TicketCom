package com.melikesivrikaya.gatewayservice.dto;

import com.melikesivrikaya.gatewayservice.dto.enums.Role;
import com.melikesivrikaya.gatewayservice.model.User;
import lombok.*;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements UserDetails {


    private Long id;
    private String username,password,phone,email;
    private Set<Role> roles;

    private List<GrantedAuthority> authorities;

    public UserDetail(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.authorities =   user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
