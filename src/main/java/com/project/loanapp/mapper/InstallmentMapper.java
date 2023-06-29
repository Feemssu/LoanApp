package com.project.loanapp.mapper;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.dto.InstallmentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstallmentMapper {

    public Installment mapToInstallment(final InstallmentDto installmentDto) {
        return new Installment.InstallmentBuilder()
                .amount(installmentDto.getAmount())
                .dueDate(installmentDto.getDueDate())
                .isPaid(installmentDto.getIsPaid())
                .build();
    }

    public InstallmentDto mapToInstallmentDto(final Installment installment) {
        return new InstallmentDto(
                installment.getInstallmentId(),
                installment.getAmount(),
                installment.getDueDate(),
                installment.getIsPaid()
        );
    }

    public List<InstallmentDto> mapToInstallmentDtoList(List<Installment> installmentList) {
        return installmentList.stream()
                .map(this::mapToInstallmentDto)
                .collect(Collectors.toList());
    }
}
