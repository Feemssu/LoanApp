package com.project.loanapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
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

    public Application(Long applicationId, BigDecimal amountOfLoan, double interest, int installment, BigDecimal paymentPerMonth, BigDecimal totalLoanRepayment) {
        this.applicationId = applicationId;
        this.amountOfLoan = amountOfLoan;
        this.interest = interest;
        this.installment = installment;
        this.paymentPerMonth = paymentPerMonth;
        this.totalLoanRepayment = totalLoanRepayment;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
