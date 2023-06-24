package com.project.loanapp.controller;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.UserDto;
import com.project.loanapp.exception.UserNotFoundException;
import com.project.loanapp.mapper.UserMapper;
import com.project.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    @GetMapping(value = "allusers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "allblocked")
    public ResponseEntity<List<UserDto>> getAllBlockedUsers() {
        List<User> users = userService.getAllBlockedUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "allunblocked")
    public ResponseEntity<List<UserDto>> getAllUnblockedUsers() {
        List<User> users = userService.getAllUnblockedUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "id/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.getUserById(userId)));
    }

    @GetMapping(value = "login/{login}")
    public ResponseEntity<UserDto> getUserByLogin(@PathVariable String login) throws UserNotFoundException{
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.getUserByLogin(login)));
    }

    @GetMapping(value = "email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.getUserByEmail(email)));
    }
    @PutMapping(value = "block/id/{userId}")
    public ResponseEntity<UserDto> blockUserById(@PathVariable Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        user.setBlocked(true);
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }

    @PutMapping(value =  "block/login/{login}")
    public ResponseEntity<UserDto> blockUserByLogin(@PathVariable String login) throws UserNotFoundException {
        User user = userService.getUserByLogin(login);
        user.setBlocked(true);
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }

    @PutMapping(value = "unblock/id/{userId}")
    public ResponseEntity<UserDto> unblockUserById(@PathVariable Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        user.setBlocked(false);
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }

    @PutMapping(value = "unblock/login/{login}")
    public ResponseEntity<UserDto> unblockUserByLogin(@PathVariable String login) throws UserNotFoundException {
        User user = userService.getUserByLogin(login);
        user.setBlocked(false);
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }

    @PutMapping(value = "password/{userId}")
    public ResponseEntity<UserDto> changeUserPassword(@PathVariable Long userId, @RequestBody String newPassword) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        user.setPassword(newPassword);
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }


    @DeleteMapping(value = "delete/id/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "delete/login/{login}")
    public ResponseEntity<Void> deleteUserByLogin(@PathVariable String login) {
        userService.deleteUserByLogin(login);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        if (userService.isLoginUnique(userDto.getLogin()) || userService.isEmailUnique(userDto.getEmail())) {
            User user = userMapper.mapToUser(userDto);
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
