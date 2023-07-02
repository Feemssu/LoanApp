package com.project.loanapp.controller;

import com.project.loanapp.domain.User;
import com.project.loanapp.domain.Userdata;
import com.project.loanapp.dto.UserdataDto;
import com.project.loanapp.exception.UserNotFoundException;
import com.project.loanapp.exception.UserdataNotFoundException;
import com.project.loanapp.mapper.UserdataMapper;
import com.project.loanapp.service.UserService;
import com.project.loanapp.service.UserdataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/userdata")
public class UserdataController {

    private final UserdataService userdataService;
    private final UserdataMapper userdataMapper;
    private final UserService userService;
    @GetMapping(value = "alluserdata")
    public ResponseEntity<List<UserdataDto>> getAllUserdata() {
        List<Userdata> userdataList = userdataService.getAllUserdata();
        return ResponseEntity.ok(userdataMapper.mapToUserdataDtoList(userdataList));
    }
    @GetMapping(value = "id/{userdataId}")
    public ResponseEntity<UserdataDto> getUserdataById(@PathVariable long userdataId) throws UserdataNotFoundException {
        return ResponseEntity.ok(userdataMapper.mapToUserdataDto(userdataService.getUserdataById(userdataId))); }
    @GetMapping(value = "{firstname}")
    public ResponseEntity<List<UserdataDto>> getAllUserdataByName(@PathVariable String firstname) {
        List<Userdata> userdataList = userdataService.getAllUserdataByFirstname(firstname);
        return ResponseEntity.ok(userdataMapper.mapToUserdataDtoList(userdataList));
    }

    @GetMapping(value = "{lastname}")
    public ResponseEntity<List<UserdataDto>> getAllUserdataByLastname(@PathVariable String lastname) {
        List<Userdata> userdataList = userdataService.getAllUserdataByLastname(lastname);
        return ResponseEntity.ok(userdataMapper.mapToUserdataDtoList(userdataList));
    }

    @GetMapping(value = "pesel/{pesel}")
    public ResponseEntity<UserdataDto> getUserdataByPesel(@PathVariable String pesel) throws UserdataNotFoundException {
        return ResponseEntity.ok(userdataMapper.mapToUserdataDto(userdataService.getUserdataByPesel(pesel)));
    }

    @GetMapping(value = "phone/{number}")
    public ResponseEntity<UserdataDto> getUserdataByPhoneNumber(@PathVariable String number) throws UserdataNotFoundException {
        return ResponseEntity.ok(userdataMapper.mapToUserdataDto(userdataService.getUserdataByPhoneNumber(number)));
    }

    @PutMapping(value = "edit")
    public ResponseEntity<UserdataDto> updateUserdata(@RequestBody UserdataDto userdataDto) {
        Userdata userdata = userdataMapper.mapToUserdata(userdataDto);
        Userdata userdataCopy = userdataService.saveUserdata(userdata);
        return ResponseEntity.ok(userdataMapper.mapToUserdataDto(userdataCopy));
    }

    @DeleteMapping(value = "delete/{userdataId}")
    public ResponseEntity<Void> deleteUserdataById(@PathVariable long userdataId) {
        userdataService.deleteUserdataById(userdataId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "create")
    public ResponseEntity<Void> createUserdata(@RequestBody UserdataDto userdataDto, @RequestParam Long userId) throws UserNotFoundException {
        if (userdataService.isPeselUnique(userdataDto.getPesel()) || userdataService.isPhoneUnique(userdataDto.getPhoneNumber())) {
            User user = userService.getUserById(userId);
            Userdata userdata = userdataMapper.mapToUserdata(userdataDto);
            userdata.setUser(user);
            user.setAuthorized(true);
            userdataService.saveUserdata(userdata);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
