package com.project.loanapp.service;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.exception.InstallmentNotFoundException;
import com.project.loanapp.repository.InstallmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstallmentService {

    private final InstallmentRepository installmentRepository;

    public List<Installment> getAllInstallment() {
        return installmentRepository.findAll();
    }

    public Installment getInstallmentById(Long installmentId) throws InstallmentNotFoundException {
        return installmentRepository.findById(installmentId).orElseThrow(InstallmentNotFoundException::new);
    }

    public Installment saveInstallment(final Installment installment){
        return installmentRepository.save(installment);
    }

}
