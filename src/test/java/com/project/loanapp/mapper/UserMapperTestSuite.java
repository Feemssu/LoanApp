package com.project.loanapp.mapper;

import com.project.loanapp.domain.User;
import com.project.loanapp.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserMapperTestSuite {


    @Autowired
    private UserMapper userMapper;

    @Test
    void testMapToUser() {
        //Given
        UserDto userDto = new UserDto(1L, "test", "test", "test@test.com",
                false, false, false, new BigDecimal(0));

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        assertEquals(user.getEmail(), userDto.getEmail());
    }

    @Test
    void testMapToUserDto() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        assertEquals(user.getLogin(), userDto.getLogin());
    }

    @Test
    void testMapToUserDtoList() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        List<User> userList = new ArrayList<>();
        userList.add(user);

        //When
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userList);

        //Then
        assertEquals(userDtoList.get(0).getPassword(), user.getPassword());
    }
}
