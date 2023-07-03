package com.project.loanapp.service;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.exception.InstallmentNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InstallmentServiceTestSuite {

    @Autowired
    private InstallmentService installmentService;

    @Test
    void testSaveAndGetInstallmentById() throws InstallmentNotFoundException {
        //Given
        Installment installment = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(1000))
                .dueDate(LocalDate.now())
                .isPaid(false)
                .build();

        installmentService.saveInstallment(installment);

        //When
        Installment installment1 = installmentService.getInstallmentById(installment.getInstallmentId());


        //Then
        assertEquals(installment.getDueDate(), installment1.getDueDate());

        //CleanUp
        installmentService.deleteInstallmentById(installment.getInstallmentId());
    }

    @Test
    void testGetAllInstallments() {
        //Given
        Installment installment = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(1000))
                .dueDate(LocalDate.now())
                .isPaid(false)
                .build();

        Installment installment1 = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(1000))
                .dueDate(LocalDate.now())
                .isPaid(false)
                .build();

        Installment installment2 = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(1000))
                .dueDate(LocalDate.now())
                .isPaid(false)
                .build();

        installmentService.saveInstallment(installment);
        installmentService.saveInstallment(installment1);
        installmentService.saveInstallment(installment2);

        //When
        List<Installment> installmentList = installmentService.getAllInstallment();

        //Then
        assertEquals(3, installmentList.size());

        //CleanUp
        installmentService.deleteInstallmentById(installment.getInstallmentId());
        installmentService.deleteInstallmentById(installment1.getInstallmentId());
        installmentService.deleteInstallmentById(installment2.getInstallmentId());
    }
}
