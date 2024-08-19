package com.melikesivrikaya.gatewayservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;


@Data
@AllArgsConstructor
public class UserDetailsDto {

    private Collection<? extends GrantedAuthority> authorities;

    private String password;

    private String username;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;
}
