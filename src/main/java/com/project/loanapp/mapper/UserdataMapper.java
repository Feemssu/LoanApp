package com.project.loanapp.mapper;

import com.project.loanapp.domain.Userdata;
import com.project.loanapp.dto.UserdataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserdataMapper {

    public Userdata mapToUserdata(final UserdataDto userDataDto) {
        return new Userdata(
                userDataDto.getUserDataId(),
                userDataDto.getFirstname(),
                userDataDto.getSecondname(),
                userDataDto.getLastname(),
                userDataDto.getPesel(),
                userDataDto.getPhoneNumber(),
                userDataDto.getDateOfBirth(),
                userDataDto.getAddress(),
                userDataDto.getUser()
        );
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
