package com.project.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class InstallmentDto {

    private Long installmentId;
    private BigDecimal amount;
    private LocalDate dueDate;
    private Boolean isPaid;
}
