package com.project.loanapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "APPLICATIONS")
public class Application {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "APPLICATION_ID", unique = true)
    private Long applicationId;

    @NotNull
    @Column(name = "AMOUNT_OF_LOAN")
    private BigDecimal amountOfLoan;

    @NotNull
    @Column(name = "INTEREST")
    private double interest;

    @NotNull
    @Column(name = "INSTALLMENT")
    private int installment;

    @Column(name = "PAYMENT_PER_MONTH")
    private BigDecimal paymentPerMonth;

    @Column(name = "TOTAL_LOAN_REPAYMENT")
    private BigDecimal totalLoanRepayment;

    public Application(BigDecimal amountOfLoan, double interest, int installment){
        this.amountOfLoan = amountOfLoan;
        this.interest = interest;
        this.installment = installment;
    }
}
