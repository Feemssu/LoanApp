package com.project.loanapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INSTALMENT")
public class Installment {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "INSTALLMENT_ID")
    private Long installmentId;

    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @NotNull
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @NotNull
    @Column(name = "IS_PAID")
    private Boolean isPaid;


    private Installment(Long installmentId, BigDecimal amount, LocalDate dueDate, Boolean isPaid) {
        this.installmentId = installmentId;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public Installment(BigDecimal amount, LocalDate dueDate, Boolean isPaid) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public Installment(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;


    public static class InstallmentBuilder {

        private BigDecimal amount;
        private LocalDate dueDate;
        private Boolean isPaid;

        public InstallmentBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public InstallmentBuilder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public InstallmentBuilder isPaid(Boolean isPaid) {
            this.isPaid = isPaid;
            return this;
        }

        public Installment build() {
            return new Installment(amount, dueDate, isPaid);
        }
    }

}
