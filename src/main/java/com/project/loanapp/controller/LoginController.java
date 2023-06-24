package com.project.loanapp.controller;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.LoginDto;
import com.project.loanapp.dto.UserDto;
import com.project.loanapp.exception.UserNotFoundException;
import com.project.loanapp.mapper.UserMapper;
import com.project.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class LoginController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping(value = "register")
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        if (userService.isLoginUnique(userDto.getLogin()) || userService.isEmailUnique(userDto.getEmail())) {
            User user = userMapper.mapToUser(userDto);
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(value = "login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) throws UserNotFoundException {
        User user = userService.getUserByLogin(loginDto.getLogin());
        if(user.getPassword().equals(loginDto.getPassword())) {
            user.setLoggedIn(true);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Błędne dane");
        }
    }

    @PostMapping(value = "logout")
    public ResponseEntity<String> logoutUser(@RequestParam Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        user.setLoggedIn(false);
        return ResponseEntity.ok("Użytkownik został wylogowany");
    }
}
