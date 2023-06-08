package com.project.loanapp.service;

import com.project.loanapp.domain.Application;
import com.project.loanapp.exception.ApplicationNotFoundException;
import com.project.loanapp.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getById(final Long applicationId) throws ApplicationNotFoundException {
        return applicationRepository.findById(applicationId).orElseThrow(ApplicationNotFoundException::new);
    }

    public Application saveApplication(final Application application) {
        return applicationRepository.save(application);
    }

}
