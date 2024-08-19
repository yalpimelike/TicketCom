package com.melikesivrikaya.authservice.converter;


import com.melikesivrikaya.authservice.dto.UserDetailsDto;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsConverter {
    public static UserDetailsDto toDto(UserDetails userDetails) {
        return UserDetailsDto.builder()
                .username(userDetails.getUsername())
                .password(userDetails.getPassword())
                .authorities(userDetails.getAuthorities())
                .isAccountNonExpired(userDetails.isAccountNonExpired())
                .isAccountNonLocked(userDetails.isAccountNonLocked())
                .isCredentialsNonExpired(userDetails.isCredentialsNonExpired())
                .isEnabled(userDetails.isEnabled())
                .build();
    }
}
