package com.melikesivrikaya.authservice.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSaveRequest {

    private String email;
    private String password;

}
