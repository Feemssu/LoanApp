package com.project.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDataDto {

    private Long userDataId;
    private String firstname;
    private String secondname;
    private String lastname;
    private int pesel;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String address;
}
