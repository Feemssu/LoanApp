package com.project.loanapp.mapper;

import com.project.loanapp.domain.Application;
import com.project.loanapp.dto.ApplicationDto;
import com.project.loanapp.dto.InstallmentDto;
import com.project.loanapp.service.Calculation;
import com.project.loanapp.service.Credit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationMapperTestSuite {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private Credit credit;

    @Autowired
    private Calculation calculation;

    @Test
    void testMapToApplication() {
        //Given
        ApplicationDto applicationDto = new ApplicationDto(1L, new BigDecimal(1000), 12, List.of());

        //When
        Application application = applicationMapper.mapToApplication(applicationDto);

        //Then
        assertEquals(application.getAmountOfLoan(), applicationDto.getAmountOfLoan());
    }

    @Test
    void testMapToApplicationDto() {
        //Given
        Application application = new Application.ApplicationBuilder()
                .amountOfLoan(new BigDecimal(1000))
                .numberOfInstallment(12)
                .calculation(calculation)
                .credit(credit)
                .build();

        //When
        ApplicationDto applicationDto = applicationMapper.mapToApplicationDto(application);

        //Then
        assertEquals(application.getInstallments().size(), applicationDto.getInstallments().size());
    }

    @Test
    void testMapToApplicationDtoList() {
        //Given
        Application application = new Application.ApplicationBuilder()
                .amountOfLoan(new BigDecimal(1000))
                .numberOfInstallment(12)
                .calculation(calculation)
                .credit(credit)
                .build();

        List<Application> applicationList = new ArrayList<>();
        applicationList.add(application);

        //When
        List<ApplicationDto> applicationDtoList = applicationMapper.mapToApplicationDtoList(applicationList);

        //Then
        assertEquals(applicationDtoList.get(0).getNumberOfInstallment(), application.getNumberOfInstallment());
    }
}
