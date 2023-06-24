package com.project.loanapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS")
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

    @Column(name = "ACCOUNT_BALANCE")
    private BigDecimal accountBalance;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(Long userId, String login, String password, String email) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(Long userId, String login, String password, String email, boolean isBlocked, boolean isAuthorized) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.isBlocked = isBlocked;
        this.isAuthorized = isAuthorized;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Userdata userdata;


    public void setUserdata(Userdata userdata) {
        this.userdata = userdata;
        this.isAuthorized = true;
    }

    @OneToMany(
            targetEntity = Application.class,
            cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY

    )
    private List<Application> application = new ArrayList<>();
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isBlocked=" + isBlocked +
                ", isAuthorized=" + isAuthorized +
                ", userdata=" + userdata +
                ", accountBalance=" + accountBalance +
              //  ", application=" + application +
                '}';
    }
}
