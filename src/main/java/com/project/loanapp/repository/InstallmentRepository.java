package com.project.loanapp.repository;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.Installment;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface InstallmentRepository extends CrudRepository<Installment, Long> {

    @Override
    Installment save(Installment installment);
}
