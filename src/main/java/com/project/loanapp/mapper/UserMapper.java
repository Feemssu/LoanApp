package com.project.loanapp.mapper;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.isBlocked(),
                userDto.isAuthorized()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.isBlocked(),
                user.isAuthorized()
        );
    }
}
