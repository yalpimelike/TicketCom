package com.melikesivrikaya.authservice.model;

import com.melikesivrikaya.authservice.model.enums.Role;
import com.melikesivrikaya.authservice.model.enums.UserType;
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
    private UserType userType;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", userType=" + userType +
                '}';
    }
}
