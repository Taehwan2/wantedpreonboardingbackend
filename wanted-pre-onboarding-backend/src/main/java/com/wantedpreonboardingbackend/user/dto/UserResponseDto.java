package com.wantedpreonboardingbackend.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;

    private String name;

    private String email;
}
