package com.project.loanapp.mapper;

import com.project.loanapp.domain.Application;
import com.project.loanapp.dto.ApplicationDto;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public Application mapToApplication(final ApplicationDto applicationDto) {
        return new Application(
                applicationDto.getApplicationId(),
                applicationDto.getAmountOfLoan(),
                applicationDto.getInterest(),
                applicationDto.getInstallment(),
                applicationDto.getPaymentPerMonth(),
                applicationDto.getTotalLoanRepayment()
        );
    }

    public ApplicationDto mapToApplicationDto(final Application application) {
        return new ApplicationDto(
                application.getApplicationId(),
                application.getAmountOfLoan(),
                application.getInterest(),
                application.getInstallment(),
                application.getPaymentPerMonth(),
                application.getTotalLoanRepayment()
        );
    }
}
