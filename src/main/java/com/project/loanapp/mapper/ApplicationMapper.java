package com.project.loanapp.mapper;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.Installment;
import com.project.loanapp.dto.ApplicationDto;
import com.project.loanapp.dto.InstallmentDto;
import com.project.loanapp.service.Calculation;
import com.project.loanapp.service.Credit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ApplicationMapper {

    private final Calculation calculation;

    private final Credit credit;
    private final InstallmentMapper installmentMapper;
    public Application mapToApplication(final ApplicationDto applicationDto) {
        Application application = new Application.ApplicationBuilder()
                .amountOfLoan(applicationDto.getAmountOfLoan())
                .numberOfInstallment(applicationDto.getNumberOfInstallment())
                .calculation(calculation)
                .credit(credit)
                .build();
        return application;
    }

    public ApplicationDto mapToApplicationDto(final Application application) {
        ApplicationDto applicationDto = new ApplicationDto (
                application.getApplicationId(),
                application.getAmountOfLoan(),
                application.getNumberOfInstallment(),
                installmentMapper.mapToInstallmentDtoList(application.getInstallments())
        );
        return applicationDto;
    }

    public List<ApplicationDto> mapToApplicationDtoList(final List<Application> applicationList) {
        return applicationList.stream()
                .map(this::mapToApplicationDto)
                .collect(Collectors.toList());
    }
}
