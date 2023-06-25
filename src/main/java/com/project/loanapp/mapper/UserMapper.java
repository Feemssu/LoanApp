package com.project.loanapp.mapper;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.isBlocked(),
                userDto.isAuthorized(),
                userDto.isLoggedIn(),
                userDto.getAccountBalance()
        );
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
