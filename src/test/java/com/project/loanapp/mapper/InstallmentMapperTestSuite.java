package com.project.loanapp.mapper;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.dto.InstallmentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InstallmentMapperTestSuite {

    @Autowired
    private InstallmentMapper installmentMapper;

    @Test
    void testMapToInstallment() {
        //Given
        InstallmentDto installmentDto = new InstallmentDto(1L, new BigDecimal(1000),
                LocalDate.now(), false);

        //When
        Installment installment = installmentMapper.mapToInstallment(installmentDto);

        //Then
        assertEquals(installment.getAmount(), installmentDto.getAmount());
    }

    @Test
    void testMapToInstallmentDto() {
        //Given
        Installment installment = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(1000))
                .dueDate(LocalDate.now())
                .isPaid(false)
                .build();

        //When
        InstallmentDto installmentDto = installmentMapper.mapToInstallmentDto(installment);

        //Then
        assertEquals(installment.getIsPaid(), installmentDto.getIsPaid());
    }

    @Test
    void testMapToInstallmentDtoList() {
        //Given
        Installment installment = new Installment.InstallmentBuilder()
                .amount(new BigDecimal(1000))
                .dueDate(LocalDate.now())
                .isPaid(false)
                .build();

        List<Installment> installmentList = new ArrayList<>();
        installmentList.add(installment);

        //When
        List<InstallmentDto> installmentDtoList = installmentMapper.mapToInstallmentDtoList(installmentList);

        //Then
        assertEquals(installmentDtoList.get(0).getDueDate(), installment.getDueDate());
    }
}
