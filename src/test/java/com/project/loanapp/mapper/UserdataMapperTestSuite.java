package com.project.loanapp.mapper;

import com.project.loanapp.domain.User;
import com.project.loanapp.domain.Userdata;
import com.project.loanapp.dto.UserdataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserdataMapperTestSuite {

    @Autowired
    private UserdataMapper userdataMapper;

    @Test
    void mapToUserdata() {
        //Given
        UserdataDto userdataDto = new UserdataDto(1L, "test", "test", "test", "12345678901", "123456789",
                LocalDate.now(), "test", new User());

        //When
        Userdata userdata = userdataMapper.mapToUserdata(userdataDto);

        //Then
        assertEquals(userdata.getLastname(), userdataDto.getLastname());
    }

    @Test
    void mapToUserdataDto() {
        //Given
        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(new User())
                .build();

        //When
        UserdataDto userdataDto = userdataMapper.mapToUserdataDto(userdata);

        //Then
        assertEquals(userdata.getPesel(), userdataDto.getPesel());
    }

    @Test
    void mapToUserdataDtoList() {
        //Given
        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(new User())
                .build();

        List<Userdata> userdataList = new ArrayList<>();
        userdataList.add(userdata);

        //When
        List<UserdataDto> userdataDtoList = userdataMapper.mapToUserdataDtoList(userdataList);

        //Then
        assertEquals(userdataDtoList.get(0).getPhoneNumber(), userdata.getPhoneNumber());
    }
}
