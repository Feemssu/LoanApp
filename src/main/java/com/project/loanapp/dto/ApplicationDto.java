package com.project.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ApplicationDto {

    private Long applicationId;
    private BigDecimal amountOfLoan;
    private double interest;
    private int installment;
    private BigDecimal paymentPerMonth;
    private BigDecimal totalLoanRepayment;
}
