package com.project.loanapp.service;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.Installment;
import com.project.loanapp.exception.ApplicationNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationServiceTestSuite {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private InstallmentService installmentService;
    @Autowired
    private Credit credit;
    @Autowired
    private Calculation calculation;

    @Test
    void testSaveAndGetByIdAndDelete() throws ApplicationNotFoundException {
        //Given
        Application application = new Application.ApplicationBuilder()
                .amountOfLoan(new BigDecimal(1000))
                .numberOfInstallment(12)
                .calculation(calculation)
                .credit(credit)
                .build();

        applicationService.saveApplication(application);

        //When
        Application application1 = applicationService.getById(application.getApplicationId());

        //Then
        assertEquals(application1.getNumberOfInstallment(), application.getNumberOfInstallment());

        //CleanUp
        List<Installment> installments = application.getInstallments();
        for (Installment installment: installments) {
            installmentService.deleteInstallmentById(installment.getInstallmentId());
        }
        applicationService.deleteApplicationById(application.getApplicationId());
    }

    @Test
    void testGetAllApplication() {
        //Given
        Application application = new Application.ApplicationBuilder()
                .amountOfLoan(new BigDecimal(1000))
                .numberOfInstallment(12)
                .calculation(calculation)
                .credit(credit)
                .build();

        Application application1 = new Application.ApplicationBuilder()
                .amountOfLoan(new BigDecimal(1000))
                .numberOfInstallment(12)
                .calculation(calculation)
                .credit(credit)
                .build();

        applicationService.saveApplication(application);
        applicationService.saveApplication(application1);

        //When
        List<Application> applicationList = applicationService.getAllApplications();

        //Then
        assertEquals(2, applicationList.size());

        //CleanUp
        List<Installment> installments = application.getInstallments();
        for (Installment installment: installments) {
            installmentService.deleteInstallmentById(installment.getInstallmentId());
        }
        applicationService.deleteApplicationById(application.getApplicationId());

        List<Installment> installments1 = application1.getInstallments();
        for (Installment installment: installments1) {
            installmentService.deleteInstallmentById(installment.getInstallmentId());
        }
        applicationService.deleteApplicationById(application1.getApplicationId());
    }
}
