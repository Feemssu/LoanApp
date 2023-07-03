package com.project.loanapp.mapper;

import com.project.loanapp.domain.Userdata;
import com.project.loanapp.dto.UserdataDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserdataMapper {

    public Userdata mapToUserdata(final UserdataDto userDataDto) {
        return new Userdata.UserdataBuilder()
                .firstname(userDataDto.getFirstname())
                .secondname(userDataDto.getSecondname())
                .lastname(userDataDto.getLastname())
                .pesel(userDataDto.getPesel())
                .phoneNumber(userDataDto.getPhoneNumber())
                .dateOfBirth(userDataDto.getDateOfBirth())
                .address(userDataDto.getAddress())
                .user(userDataDto.getUser())
                .build();
    }

    public UserdataDto mapToUserdataDto(final Userdata userData) {
        return new UserdataDto(
                userData.getUserDataId(),
                userData.getFirstname(),
                userData.getSecondname(),
                userData.getLastname(),
                userData.getPesel(),
                userData.getPhoneNumber(),
                userData.getDateOfBirth(),
                userData.getAddress(),
                userData.getUser()
        );
    }

    public List<UserdataDto> mapToUserdataDtoList(final List<Userdata> userdataList) {
        return userdataList.stream()
                .map(this::mapToUserdataDto)
                .collect(Collectors.toList());
    }
}
