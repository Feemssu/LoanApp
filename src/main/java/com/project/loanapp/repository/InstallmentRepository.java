package com.project.loanapp.repository;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.Installment;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface InstallmentRepository extends CrudRepository<Installment, Long> {

    @Override
    Installment save(Installment installment);

    @Override
    List<Installment> findAll();

    @Override
    Optional<Installment> findById(Long installmentId);
}
