package com.project.loanapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERDATA")
public class Userdata {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USERDATA_ID", unique = true)
    private Long userDataId;

    @NotNull
    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "SECONDNAME")
    private String secondname;

    @NotNull
    @Column(name = "LASTNAME")
    private String lastname;

    @NotNull
    @Column(name = "PESEL", unique = true)
    private String pesel;

    @NotNull
    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    @NotNull
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    private Userdata(String firstname, String secondname, String lastname, String pesel, String phoneNumber, LocalDate dateOfBirth, String address, User user) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.user = user;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public static class UserdataBuilder {

        private String firstname;
        private String secondname;
        private String lastname;
        private String pesel;
        private String phoneNumber;
        private LocalDate dateOfBirth;
        private String address;
        private User user;

        public UserdataBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserdataBuilder secondname(String secondname) {
            this.secondname = secondname;
            return this;
        }

        public UserdataBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserdataBuilder pesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public UserdataBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserdataBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserdataBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserdataBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Userdata build() {
            return new Userdata(firstname, secondname, lastname, pesel, phoneNumber, dateOfBirth, address, user);
        }
    }

}
