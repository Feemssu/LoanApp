package com.project.loanapp.mapper;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User.UserBuilder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.isBlocked(),
                user.isAuthorized(),
                user.isLoggedIn(),
                user.getAccountBalance()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
