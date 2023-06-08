package com.project.loanapp.service;

import com.project.loanapp.domain.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class Calculation {

    public BigDecimal creditCostCalculate(Application application) {
       return application.getAmountOfLoan().multiply(BigDecimal.valueOf(application.getInterest()))
               .multiply(BigDecimal.valueOf(application.getInstallment())).divide(new BigDecimal(12),2,RoundingMode.HALF_UP);
    }

    public BigDecimal totalCreditCostCalculate(Application application) {
        return creditCostCalculate(application).add(application.getAmountOfLoan());
    }

    public BigDecimal paymentPerMonthCalculate(Application application) {
        return totalCreditCostCalculate(application).divide(BigDecimal.valueOf(application.getInstallment()), 2, RoundingMode.HALF_UP);
    }
}
