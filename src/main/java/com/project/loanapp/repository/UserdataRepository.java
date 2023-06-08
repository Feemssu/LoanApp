package com.project.loanapp.repository;

import com.project.loanapp.domain.Userdata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserdataRepository extends CrudRepository<Userdata, Long> {

    @Override
    List<Userdata> findAll();

    @Override
    Userdata save(Userdata userData);

    @Override
    Optional<Userdata> findById(Long userDataId);

    @Override
    void deleteById(Long userDataId);

}
