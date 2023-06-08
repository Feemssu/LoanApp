package com.project.loanapp.controller;

import com.project.loanapp.dto.UserDataDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/userdata")
public class UserDataController {

    @GetMapping(value = "name")
    public List<UserDataDto> getAllUsersByName() {
        return new ArrayList<>();
    }

    @GetMapping(value = "lastname")
    public List<UserDataDto> getAllUsersByLastname() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{pesel}")
    public UserDataDto getUserByPesel(@PathVariable int pesel) {
        return new UserDataDto();
    }

    @PutMapping(value = "edit")
    public UserDataDto updateUserData() {
        return new UserDataDto();
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteUserDataById(@PathVariable long id) {

    }

    @PostMapping(value = "createuserdata")
    public void createUserData() {

    }
}
