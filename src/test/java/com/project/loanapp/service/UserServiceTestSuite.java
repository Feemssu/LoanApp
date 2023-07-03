package com.project.loanapp.service;

import com.project.loanapp.domain.User;
import com.project.loanapp.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTestSuite {

    @Autowired
    private UserService userService;

    @Test
    void testSaveAndGetByIdAndDeleteUserById() throws UserNotFoundException {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        userService.saveUser(user);

        //When
        User user1 = userService.getUserById(user.getUserId());

        //Then
        assertEquals(user.getLogin(), user1.getLogin());

        //CleanUp
        userService.deleteUserById(user.getUserId());
    }

    @Test
    void testGetAllUsers() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        User user1 = new User.UserBuilder()
                .login("test1")
                .password("test")
                .email("test1@test.com")
                .build();

        userService.saveUser(user);
        userService.saveUser(user1);

        //When
        List<User> userList = userService.getAllUsers();

        //Then
        assertEquals(2, userList.size());

        //CleanUp
        userService.deleteUserById(user.getUserId());
        userService.deleteUserById(user1.getUserId());
    }

    @Test
    void testGetAllBlockedUsers() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        User user1 = new User.UserBuilder()
                .login("test1")
                .password("test")
                .email("test1@test.com")
                .build();

        User user2 = new User.UserBuilder()
                .login("test2")
                .password("test")
                .email("test2@test.com")
                .build();

        user.setBlocked(true);
        user1.setBlocked(true);

        userService.saveUser(user);
        userService.saveUser(user1);
        userService.saveUser(user2);

        //When
        List<User> userList = userService.getAllBlockedUsers();

        //Then
        assertEquals(2, userList.size());

        //CleanUp
        userService.deleteUserById(user.getUserId());
        userService.deleteUserById(user1.getUserId());
        userService.deleteUserById(user2.getUserId());
    }

    @Test
    void testGetAllUnblockedUsers() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        User user1 = new User.UserBuilder()
                .login("test1")
                .password("test")
                .email("test1@test.com")
                .build();

        User user2 = new User.UserBuilder()
                .login("test2")
                .password("test")
                .email("test2@test.com")
                .build();

        user.setBlocked(true);
        user1.setBlocked(true);

        userService.saveUser(user);
        userService.saveUser(user1);
        userService.saveUser(user2);

        //When
        List<User> userList = userService.getAllUnblockedUsers();

        //Then
        assertEquals(1, userList.size());

        //CleanUp
        userService.deleteUserById(user.getUserId());
        userService.deleteUserById(user1.getUserId());
        userService.deleteUserById(user2.getUserId());
    }

    @Test
    void testGetUserByLoginAndDeleteByLogin() throws UserNotFoundException {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        userService.saveUser(user);

        //When
        User user1 = userService.getUserByLogin(user.getLogin());

        //Then
        assertEquals(user.getLogin(), user1.getLogin());

        //CleanUp
        userService.deleteUserByLogin(user.getLogin());
    }

    @Test
    void testGetUserByEmail() throws UserNotFoundException {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        userService.saveUser(user);

        //When
        User user1 = userService.getUserByEmail(user.getEmail());

        //Then
        assertEquals(user.getEmail(), user1.getEmail());

        //CleanUp
        userService.deleteUserById(user.getUserId());
    }

    @Test
    void testIsLoginUnique() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        userService.saveUser(user);

        //When
        boolean result = userService.isLoginUnique("test");

        //Then
        assertFalse(result);

        //CleanUp
        userService.deleteUserByLogin(user.getLogin());
    }

    @Test
    void testIsEmailUnique() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        userService.saveUser(user);

        //When
        boolean result = userService.isEmailUnique("test@test.com");

        //Then
        assertFalse(result);

        //CleanUp
        userService.deleteUserByLogin(user.getLogin());
    }
}
