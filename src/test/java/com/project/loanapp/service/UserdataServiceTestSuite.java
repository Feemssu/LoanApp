package com.project.loanapp.service;

import com.project.loanapp.domain.User;
import com.project.loanapp.domain.Userdata;
import com.project.loanapp.exception.UserdataNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UserdataServiceTestSuite {

    @Autowired
    private UserdataService userdataService;


    @Test
    void testSaveAndDeleteByIdAndGetById() throws UserdataNotFoundException {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();


        userdataService.saveUserdata(userdata);

        //When
        Userdata userdata1 = userdataService.getUserdataById(userdata.getUserDataId());

        //Then
        assertEquals(userdata.getPesel(), userdata1.getPesel());

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
    }

    @Test
    void testGetAllUserdata() {
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

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();

        Userdata userdata1 = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678911")
                .phoneNumber("123456781")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user1)
                .build();

        userdataService.saveUserdata(userdata);
        userdataService.saveUserdata(userdata1);

        //When
        List<Userdata> userdataList = userdataService.getAllUserdata();

        //Then
        assertEquals(2, userdataList.size());

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
        userdataService.deleteUserdataById(userdata1.getUserDataId());
    }

    @Test
    void getUserdataByPesel() throws UserdataNotFoundException {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();


        userdataService.saveUserdata(userdata);

        //When
        Userdata userdata1 = userdataService.getUserdataByPesel("12345678901");

        //Then
        assertEquals(userdata.getPesel(), userdata1.getPesel());

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
    }

    @Test
    void getUserdataByPhone() throws UserdataNotFoundException {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();


        userdataService.saveUserdata(userdata);

        //When
        Userdata userdata1 = userdataService.getUserdataByPhoneNumber("123456789");

        //Then
        assertEquals(userdata.getPhoneNumber(), userdata1.getPhoneNumber());

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
    }

    @Test
    void testIsPeselUnique() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();


        userdataService.saveUserdata(userdata);

        //When
        boolean result = userdataService.isPeselUnique("12345678901");

        //Then
        assertFalse(result);

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());

    }

    @Test
    void testIsPhoneUnique() {
        //Given
        User user = new User.UserBuilder()
                .login("test")
                .password("test")
                .email("test@test.com")
                .build();

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();


        userdataService.saveUserdata(userdata);

        //When
        boolean result = userdataService.isPhoneUnique("123456789");

        //Then
        assertFalse(result);

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
    }

    @Test
    void testGetAllUserdataByFirstname() {
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

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();

        Userdata userdata1 = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678911")
                .phoneNumber("123456781")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user1)
                .build();

        userdataService.saveUserdata(userdata);
        userdataService.saveUserdata(userdata1);

        //When
        List<Userdata> userdataList = userdataService.getAllUserdataByFirstname("test");

        //Then
        assertEquals(2, userdataList.size());

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
        userdataService.deleteUserdataById(userdata1.getUserDataId());
    }

    @Test
    void testGetAllUserdataByLastname() {
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

        Userdata userdata = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678901")
                .phoneNumber("123456789")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user)
                .build();

        Userdata userdata1 = new Userdata.UserdataBuilder()
                .firstname("test")
                .secondname("test")
                .lastname("test")
                .pesel("12345678911")
                .phoneNumber("123456781")
                .dateOfBirth(LocalDate.now())
                .address("test")
                .user(user1)
                .build();

        userdataService.saveUserdata(userdata);
        userdataService.saveUserdata(userdata1);

        //When
        List<Userdata> userdataList = userdataService.getAllUserdataByLastname("test");

        //Then
        assertEquals(2, userdataList.size());

        //CleanUp
        userdataService.deleteUserdataById(userdata.getUserDataId());
        userdataService.deleteUserdataById(userdata1.getUserDataId());
    }
}
