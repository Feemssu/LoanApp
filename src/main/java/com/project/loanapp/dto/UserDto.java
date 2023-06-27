package com.project.loanapp.dto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private boolean isLoggedIn;
    private BigDecimal accountBalance;
}
