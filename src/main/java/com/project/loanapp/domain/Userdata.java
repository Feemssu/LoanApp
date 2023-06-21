package com.project.loanapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
    @Column(name = "PESEL")
    private int pesel;

    @NotNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NotNull
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    public Userdata(String firstname, String secondname, String lastname, int pesel, String phoneNumber, LocalDate dateOfBirth, String address) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Userdata(Long userDataId, String firstname, String secondname, String lastname, int pesel, String phoneNumber, LocalDate dateOfBirth, String address) {
        this.userDataId = userDataId;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Override
    public String toString() {
        return "Userdata{" +
                "userDataId=" + userDataId +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pesel=" + pesel +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                '}';
    }
}
