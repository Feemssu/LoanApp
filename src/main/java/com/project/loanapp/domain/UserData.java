package com.project.loanapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USERDATAS")
public class UserData {

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
}
