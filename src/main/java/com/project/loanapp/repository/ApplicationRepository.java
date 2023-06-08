package com.project.loanapp.repository;

import com.project.loanapp.domain.Application;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ApplicationRepository extends CrudRepository<Application, Long> {

    @Override
    List<Application> findAll();

    @Override
    Application save(Application application);

    @Override
    Optional<Application> findById(Long applicationId);

    @Override
    void deleteById(Long applicationId);
}
