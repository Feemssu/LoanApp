package com.project.loanapp.mapper;

import com.project.loanapp.domain.Application;
import com.project.loanapp.dto.ApplicationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationMapper {

    public Application mapToApplication(final ApplicationDto applicationDto) {
        return new Application.ApplicationBuilder()
                .amountOfLoan(applicationDto.getAmountOfLoan())
                .numberOfInstallment(applicationDto.getNumberOfInstallment())
                .creditCost(applicationDto.getCreditCost())
                .paymentPerMonth(applicationDto.getPaymentPerMonth())
                .totalLoanRepayment(applicationDto.getTotalLoanRepayment())
                .installments(applicationDto.getInstallments())
                .build();
    }

    public ApplicationDto mapToApplicationDto(final Application application) {
        return new ApplicationDto(
                application.getApplicationId(),
                application.getAmountOfLoan(),
                application.getInterest(),
                application.getNumberOfInstallment(),
                application.getCreditCost(),
                application.getPaymentPerMonth(),
                application.getTotalLoanRepayment(),
                application.getInstallments()
        );
    }

    public List<ApplicationDto> mapToApplicationDtoList(final List<Application> applicationList) {
        return applicationList.stream()
                .map(this::mapToApplicationDto)
                .collect(Collectors.toList());
    }
}
