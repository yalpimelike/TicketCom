package com.melikesivrikaya.gatewayservice.model;

import com.melikesivrikaya.gatewayservice.dto.enums.Role;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username,password,phone,email;
    private Set<Role> roles;

}
