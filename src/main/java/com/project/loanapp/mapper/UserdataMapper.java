package com.project.loanapp.mapper;

import com.project.loanapp.domain.Userdata;
import com.project.loanapp.dto.UserdataDto;
import org.springframework.stereotype.Component;

@Component
public class UserdataMapper {

    public Userdata mapToUserData(final UserdataDto userDataDto) {
        return new Userdata(
                userDataDto.getUserDataId(),
                userDataDto.getFirstname(),
                userDataDto.getSecondname(),
                userDataDto.getLastname(),
                userDataDto.getPesel(),
                userDataDto.getPhoneNumber(),
                userDataDto.getDateOfBirth(),
                userDataDto.getAddress()
        );
    }

    public UserdataDto mapToUserDataDto(final Userdata userData) {
        return new UserdataDto(
                userData.getUserDataId(),
                userData.getFirstname(),
                userData.getSecondname(),
                userData.getLastname(),
                userData.getPesel(),
                userData.getPhoneNumber(),
                userData.getDateOfBirth(),
                userData.getAddress()
        );
    }
}
