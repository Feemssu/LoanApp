package com.project.loanapp.dto;

import com.project.loanapp.domain.Installment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ApplicationDto {

    private Long applicationId;
    private BigDecimal amountOfLoan;
    private double interest;
    private int numberOfInstallment;
    private BigDecimal creditCost;
    private BigDecimal paymentPerMonth;
    private BigDecimal totalLoanRepayment;
    private List<Installment> installments;
}
