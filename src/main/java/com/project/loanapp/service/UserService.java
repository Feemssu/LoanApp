package com.project.loanapp.service;

import com.project.loanapp.domain.User;
import com.project.loanapp.exception.UserNotFoundException;
import com.project.loanapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getAllBlockedUsers() {
        return userRepository.findByIsBlockedTrue();
    }

    public List<User> getAllUnblockedUsers() {
        return userRepository.findByIsBlockedFalse();
    }

    public User getUserByLogin(String login) throws UserNotFoundException {
        return userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    public boolean isLoginUnique(String login) {
        Optional<User> existingUser = userRepository.findByLogin(login);
        return existingUser.isEmpty();
    }

    public boolean isEmailUnique(String email) {
        Optional<User> existingEmail = userRepository.findByEmail(email);
        return existingEmail.isEmpty();
    }

    @Transactional
    public void deleteUserByLogin(String login) {
        userRepository.deleteByLogin(login);
    }
}
