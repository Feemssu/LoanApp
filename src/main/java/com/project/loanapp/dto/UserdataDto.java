package com.project.loanapp.dto;

import com.project.loanapp.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserdataDto {

    private Long userDataId;
    private String firstname;
    private String secondname;
    private String lastname;
    private String pesel;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String address;
    private User user;
}
