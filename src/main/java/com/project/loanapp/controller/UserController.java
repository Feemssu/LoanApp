package com.project.loanapp.controller;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.UserDto;
import com.project.loanapp.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping(value = "allusers")
    public List<UserDto> getAllUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value = "allblocked")
    public List<UserDto> getAllBlockedUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value = "allunblocked")
    public List<UserDto> getAllUnblockedUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public UserDto getUserById(@PathVariable Long id) throws UserNotFoundException {
        return new UserDto();
    }

    @GetMapping(value = "{login}")
    public UserDto getUserByLogin(@PathVariable String login) throws UserNotFoundException{
        return new UserDto();
    }

    @PutMapping(value = "block/{id}")
    public UserDto blockUserById(@PathVariable Long id) throws UserNotFoundException {
        return new UserDto();
    }

    @PutMapping(value = "block/{login}")
    public UserDto blockUserByLogin(@PathVariable String login) throws UserNotFoundException {
        return new UserDto();
    }

    @PutMapping(value = "unblock/{id}")
    public UserDto unblockUserById(@PathVariable Long id) throws UserNotFoundException {
        return new UserDto();
    }

    @PutMapping(value = "unblock/{login}")
    public UserDto unblockUserByLogin(@PathVariable String login) throws UserNotFoundException {
        return new UserDto();
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteUserById(@PathVariable Long id) throws UserNotFoundException {

    }

    @DeleteMapping(value = "delete/{login}")
    public void deleteUserByLogin(@PathVariable String login) throws UserNotFoundException {

    }

    @PutMapping(value = "email/{id}")
    public UserDto changeUserEmail(@PathVariable Long id) {
        return new UserDto();
    }

    @PutMapping(value = "password/{id}")
    public UserDto changeUserPassword(@PathVariable Long id) {
        return new UserDto();
    }

    @PostMapping(value = "/createuser")
    public void createUser(UserDto userDto){

    }
}
