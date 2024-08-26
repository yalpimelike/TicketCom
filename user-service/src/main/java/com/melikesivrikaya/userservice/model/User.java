package com.melikesivrikaya.userservice.model;

import com.melikesivrikaya.userservice.model.enums.Role;
import com.melikesivrikaya.userservice.model.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username,password,phone,email;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", roles=" + roles +
                '}';
    }
}
