package com.project.loanapp.service;

import com.project.loanapp.domain.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class Calculation {

    public BigDecimal creditCostCalculate(BigDecimal amountOfLoan, int numberOfInstallment) {
        double interest = 0.12;
       return amountOfLoan
               .multiply(BigDecimal.valueOf(interest))
               .multiply(BigDecimal.valueOf(numberOfInstallment))
               .divide(new BigDecimal(12), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal totalCreditCostCalculate(BigDecimal amountOfLoan, int numberOfInstallment) {
        return creditCostCalculate(amountOfLoan, numberOfInstallment).add(amountOfLoan);
    }

    public BigDecimal paymentPerMonthCalculate(BigDecimal amountOfLoan, int numberOfInstallment) {
        return totalCreditCostCalculate(amountOfLoan, numberOfInstallment)
                .divide(BigDecimal.valueOf(numberOfInstallment), 2, RoundingMode.HALF_UP);
    }
}
