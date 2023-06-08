package com.project.loanapp.mapper;

import com.project.loanapp.domain.UserData;
import com.project.loanapp.dto.UserDataDto;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public UserData mapToUserData(final UserDataDto userDataDto) {
        return new UserData(
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

    public UserDataDto mapToUserDataDto(final UserData userData) {
        return new UserDataDto(
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
