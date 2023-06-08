package com.project.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDto {

    private Long userId;
    private String login;
    private String password;
    private String email;
    private boolean isBlocked;
    private boolean isAuthorized;
}
