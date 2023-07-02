package com.project.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ApplicationDto {

    private Long applicationId;
    private BigDecimal amountOfLoan;
    private int numberOfInstallment;
    private List<InstallmentDto> installments = new ArrayList<>();

}

