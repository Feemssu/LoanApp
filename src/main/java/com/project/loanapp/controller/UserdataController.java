package com.project.loanapp.controller;

import com.project.loanapp.dto.UserdataDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/userdata")
public class UserdataController {

    @GetMapping(value = "alluserdata")
    public List<UserdataDto> getAllUserdata(){return new ArrayList<>();}
    @GetMapping(value = "{id}")
    public List<UserdataDto> getUserdataById(@PathVariable long id) { return new ArrayList<>(); }
    @GetMapping(value = "name")
    public List<UserdataDto> getAllUserdataByName() {
        return new ArrayList<>();
    }

    @GetMapping(value = "lastname")
    public List<UserdataDto> getAllUserdataByLastname() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{pesel}")
    public UserdataDto getUserdataByPesel(@PathVariable int pesel) {
        return new UserdataDto();
    }

    @PutMapping(value = "edit")
    public UserdataDto updateUserdata() {
        return new UserdataDto();
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteUserdataById(@PathVariable long id) {

    }

    @PostMapping(value = "createuserdata")
    public void createUserdata() {

    }
}
