package com.project.loanapp.dto;

import com.project.loanapp.domain.Installment;
import lombok.*;

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

