package com.project.loanapp.controller;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.User;
import com.project.loanapp.dto.ApplicationDto;
import com.project.loanapp.exception.ApplicationNotFoundException;
import com.project.loanapp.exception.UserNotFoundException;
import com.project.loanapp.mapper.ApplicationMapper;
import com.project.loanapp.service.ApplicationService;
import com.project.loanapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/application")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;
    private final UserService userService;
    @GetMapping(value = "allapplications")
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applicationMapper.mapToApplicationDtoList(applications));
    }

    @GetMapping(value = "{applicationId}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable long applicationId) throws ApplicationNotFoundException {
        return ResponseEntity.ok(applicationMapper.mapToApplicationDto(applicationService.getById(applicationId)));
    }

    @PostMapping(value = "create")
    public ResponseEntity<Void> createApplication(@RequestBody ApplicationDto applicationDto, @RequestParam Long userId) throws UserNotFoundException {
        User user = userService.getUserById(userId);
        Application application = applicationMapper.mapToApplication(applicationDto);
        user.setAccountBalance(applicationDto.getAmountOfLoan());
        application.setUser(user);
        applicationService.saveApplication(application);
        return ResponseEntity.ok().build();
    }

}
