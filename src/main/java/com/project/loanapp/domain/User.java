package com.project.loanapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.NonNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private Long userId;

    @NotNull
    @Column(name = "LOGIN", unique = true)
    private String login;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NonNull
    @Email(message = "Błędnie podany email")
    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked;

    @Column(name = "IS_AUTHORIZED")
    private boolean isAuthorized;

    public User(Long userId, String login, String password, String email) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
