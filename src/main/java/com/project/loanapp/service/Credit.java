package com.project.loanapp.service;

import com.project.loanapp.domain.Installment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Credit {
    private Calculation calculation;

    public List<Installment> generateSchedule(BigDecimal amountOfLoan, int numberOfInstallment) {

        List<Installment> installments = new ArrayList<>();
        for(int i = 0; i < numberOfInstallment; i++) {
            BigDecimal monthly = calculation.paymentPerMonthCalculate(amountOfLoan, numberOfInstallment);

            Installment installment = new Installment.InstallmentBuilder()
                    .amount(monthly)
                    .dueDate(LocalDate.now().plusMonths(i + 1))
                    .isPaid(false)
                    .build();

            installments.add(installment);
        }
        return installments;
    }
}
