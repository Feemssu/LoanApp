package com.project.loanapp.scheduler;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.domain.Mail;
import com.project.loanapp.repository.InstallmentRepository;
import com.project.loanapp.service.SimpleEmailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class PaymentReminderScheduler {

    private static final String SUBJECT = "Przypomnienie o płatności";
    private static final String TEXT = "Przypominamy o płatości raty w wyoskości ";
    private final SimpleEmailService simpleEmailService;
    private final InstallmentRepository installmentRepository;

    @Scheduled(cron = "0 0 0 * * MON")
    public void sendPaymentReminders() {
        LocalDate weekFromNow = LocalDate.now().plusWeeks(1);
        List<Installment> installments = installmentRepository.findInstallmentDueWithinAWeek(weekFromNow);

        for (Installment installment : installments) {
            simpleEmailService.send(
                    new Mail(
                            installment.getApplication().getUser().getEmail(),
                            SUBJECT,
                            TEXT + installment.getAmount() + " zł"
                    )
            );
        }
    }
}
