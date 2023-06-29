package com.project.loanapp.domain;

import com.project.loanapp.service.Calculation;
import com.project.loanapp.service.Credit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.core.ApplicationPushBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "APPLICATIONS")
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
    private double interest = 0.12;

    @NotNull
    @Column(name = "NUMBER_OF_INSTALLMENT")
    private int numberOfInstallment;

    @NotNull
    @Column(name = "CREDIT_COST")
    private BigDecimal creditCost;

    @Column(name = "PAYMENT_PER_MONTH")
    private BigDecimal paymentPerMonth;

    @Column(name = "TOTAL_LOAN_REPAYMENT")
    private BigDecimal totalLoanRepayment;


    public Application(BigDecimal amountOfLoan, int numberOfInstallment) {
        this.amountOfLoan = amountOfLoan;
        this.numberOfInstallment = numberOfInstallment;
    }

    private Application(Long applicationId, BigDecimal amountOfLoan, int numberOfInstallment,
                       BigDecimal creditCost, BigDecimal paymentPerMonth, BigDecimal totalLoanRepayment,
                       List<Installment> installments) {
        this.applicationId = applicationId;
        this.amountOfLoan = amountOfLoan;
        this.numberOfInstallment = numberOfInstallment;
        this.creditCost = creditCost;
        this.paymentPerMonth = paymentPerMonth;
        this.totalLoanRepayment = totalLoanRepayment;
        this.installments = installments;
    }

    private Application(BigDecimal amountOfLoan, int numberOfInstallment, BigDecimal creditCost,
                       BigDecimal paymentPerMonth, BigDecimal totalLoanRepayment,
                       List<Installment> installments) {
        this.amountOfLoan = amountOfLoan;
        this.numberOfInstallment = numberOfInstallment;
        this.creditCost = creditCost;
        this.paymentPerMonth = paymentPerMonth;
        this.totalLoanRepayment = totalLoanRepayment;
        this.installments = installments;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany
    @JoinColumn(name = "APPLICATION_ID")
    private List<Installment> installments;

    public static class ApplicationBuilder {
        private BigDecimal amountOfLoan;
        private int numberOfInstallment;
        private BigDecimal creditCost;
        private BigDecimal paymentPerMonth;
        private BigDecimal totalLoanRepayment;
        private List<Installment> installments;
        private Calculation calculation;
        private Credit credit;



        public ApplicationBuilder amountOfLoan(BigDecimal amountOfLoan) {
            this.amountOfLoan = amountOfLoan;
            return this;
        }

        public ApplicationBuilder numberOfInstallment(int numberOfInstallment) {
            this.numberOfInstallment = numberOfInstallment;
            return this;
        }


        public ApplicationBuilder calculation(Calculation calculation) {
            this.calculation = calculation;
            return this;
        }

        public ApplicationBuilder credit(Credit credit) {
            this.credit = credit;
            return this;
        }
        public Application build() {
            calculateCreditCost();
            calculateTotalCreditCost();
            calculatePaymentPerMonth();
            generateInstallments();

            return new Application(amountOfLoan, numberOfInstallment, creditCost,
                    paymentPerMonth, totalLoanRepayment, installments);
        }

        private void calculateCreditCost() {
            creditCost = calculation.creditCostCalculate(amountOfLoan, numberOfInstallment);
        }

        private void calculateTotalCreditCost() {
            totalLoanRepayment = calculation.totalCreditCostCalculate(amountOfLoan, numberOfInstallment);
        }

        private void calculatePaymentPerMonth() {
            paymentPerMonth = calculation.paymentPerMonthCalculate(amountOfLoan, numberOfInstallment);
        }

        private void generateInstallments() {
            if (credit != null) {
                installments = credit.generateSchedule(totalLoanRepayment, numberOfInstallment);
            }
        }
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", amountOfLoan=" + amountOfLoan +
                ", interest=" + interest +
                ", numberOfInstallment=" + numberOfInstallment +
                ", creditCost=" + creditCost +
                ", paymentPerMonth=" + paymentPerMonth +
                ", totalLoanRepayment=" + totalLoanRepayment +
                ", user=" + user +
                ", installments=" + installments +
                '}';
    }
}
