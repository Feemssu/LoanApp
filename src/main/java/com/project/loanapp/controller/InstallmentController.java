package com.project.loanapp.controller;

import com.project.loanapp.domain.Installment;
import com.project.loanapp.domain.User;
import com.project.loanapp.dto.InstallmentDto;
import com.project.loanapp.exception.InstallmentNotFoundException;
import com.project.loanapp.exception.UserNotFoundException;
import com.project.loanapp.mapper.InstallmentMapper;
import com.project.loanapp.service.InstallmentService;
import com.project.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/installment")
public class InstallmentController {

    private final InstallmentService installmentService;
    private final InstallmentMapper installmentMapper;
    private final UserService userService;
    @GetMapping(value = "allinstallment")
    public ResponseEntity<List<InstallmentDto>> getAllInstallment() {
        List<Installment> installments = installmentService.getAllInstallment();
        return ResponseEntity.ok(installmentMapper.mapToInstallmentDtoList(installments));
    }

    @GetMapping(value = "{installmentId}")
    public ResponseEntity<InstallmentDto> getInstallmentById(@PathVariable long installmentId) throws InstallmentNotFoundException {
        return ResponseEntity.ok(installmentMapper.mapToInstallmentDto(installmentService.getInstallmentById(installmentId)));
    }

    @PostMapping(value = "pay/{installmentId}")
    public ResponseEntity<Void> payInstallment(@PathVariable long installmentId, @RequestParam Long userId) throws UserNotFoundException, InstallmentNotFoundException {
        User user = userService.getUserById(userId);
        Installment installment = installmentService.getInstallmentById(installmentId);
        if (user.getAccountBalance().compareTo(installment.getAmount()) > 0 && !installment.getIsPaid()) {
            installment.setIsPaid(true);
            user.setAccountBalance(user.getAccountBalance().subtract(installment.getAmount()));
            installmentService.saveInstallment(installment);
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        }  else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
