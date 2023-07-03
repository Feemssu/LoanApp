package com.project.loanapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "IS_LOGGED_IN")
    private boolean isLoggedIn;


    @Column(name = "ACCOUNT_BALANCE")
    private BigDecimal accountBalance = new BigDecimal(0);


    private User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Userdata userdata;


    @OneToMany(
            targetEntity = Application.class,
            cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY

    )
    private List<Application> application = new ArrayList<>();

    public static class UserBuilder {
        private String login;
        private String password;
        private String email;
        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            return new User(login, password, email);
        }
    }
}
