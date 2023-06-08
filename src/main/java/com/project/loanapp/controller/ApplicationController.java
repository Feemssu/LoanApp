package com.project.loanapp.controller;

import com.project.loanapp.dto.ApplicationDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/application")
public class ApplicationController {

    @GetMapping(value = "allaplication")
    public List<ApplicationDto> getAllApplications() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public ApplicationDto getApplicationById(@PathVariable long id) {
        return new ApplicationDto();
    }

    @PostMapping(value = "createapplication")
    public void createApplication() {

    }
}
