package com.melikesivrikaya.authservice.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long userId;
    private String email;
    private String bio;
    //private Set<SocialMedia> socialMediaList;
}
