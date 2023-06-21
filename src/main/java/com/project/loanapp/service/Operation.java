package com.project.loanapp.service;

import com.project.loanapp.domain.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class Operation {

    public void withdraw(User user, BigDecimal money) {
        user.setAccountBalance(user.getAccountBalance().subtract(money).setScale(2,RoundingMode.DOWN));

    }

    public void deposit(User user, BigDecimal money) {
        user.setAccountBalance(user.getAccountBalance().add(money).setScale(2,RoundingMode.DOWN));
    }
}
