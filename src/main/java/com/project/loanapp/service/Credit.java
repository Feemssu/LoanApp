package com.project.loanapp.service;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.Installment;
import com.project.loanapp.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Credit {


    public boolean creditProcess(User user, Application application)  {
        if (!user.isBlocked() && user.isAuthorized()) {
            user.setAccountBalance(application.getAmountOfLoan());
            return true;
        } else {
            return false;
        }
    }

    private Calculation calculation;

    public List<Installment> generateSchedule(Application application) {

        List<Installment> installments = new ArrayList<>();
        for(int i = 0; i < application.getNumberOfInstallment(); i++) {
            BigDecimal monthly = calculation.paymentPerMonthCalculate(application);

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
