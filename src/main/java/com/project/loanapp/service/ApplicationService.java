package com.project.loanapp.service;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.Installment;
import com.project.loanapp.exception.ApplicationNotFoundException;
import com.project.loanapp.repository.ApplicationRepository;
import com.project.loanapp.repository.InstallmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final Credit credit;
    private final InstallmentRepository installmentRepository;

    private final ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getById(final Long applicationId) throws ApplicationNotFoundException {
        return applicationRepository.findById(applicationId).orElseThrow(ApplicationNotFoundException::new);
    }

    public Application saveApplication(final Application application) {
        List<Installment> installments = credit.generateSchedule(application.getAmountOfLoan(), application.getNumberOfInstallment());
        application.setInstallments(installments);
        installmentRepository.saveAll(installments);
        return applicationRepository.save(application);

    }

    public void deleteApplicationById(final Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
