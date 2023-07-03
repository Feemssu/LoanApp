package com.project.loanapp.service;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.repository.InstallmentRepository;
import com.project.loanapp.scheduler.PaymentReminderScheduler;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentReminderSchedulerTest {

    @Autowired
    private InstallmentRepository installmentRepository;

    @Test
    public void testFindInstallmentDueWithinAWeek() {
        LocalDate currentDate = LocalDate.now();
        LocalDate weekFromNow = currentDate.plusDays(7);

        Installment installment1 = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(100))
                .dueDate(LocalDate.now().plusDays(3))
                .isPaid(false)
                .build();

        Installment installment2 = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(100))
                .dueDate(LocalDate.now().plusDays(6))
                .isPaid(true)
                .build();

        Installment installment3 = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(100))
                .dueDate(LocalDate.now().plusMonths(1))
                .isPaid(false)
                .build();

        installmentRepository.save(installment1);
        installmentRepository.save(installment2);
        installmentRepository.save(installment3);

        List<Installment> result = installmentRepository.findInstallmentDueWithinAWeek(weekFromNow);


        assertEquals(result.size(), 1);

        installmentRepository.deleteById(installment1.getInstallmentId());
        installmentRepository.deleteById(installment2.getInstallmentId());
        installmentRepository.deleteById(installment3.getInstallmentId());
    }
}
