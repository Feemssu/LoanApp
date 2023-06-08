package com.project.loanapp.repository;

import com.project.loanapp.domain.Application;
import com.project.loanapp.domain.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {

    @Override
    List<UserData> findAll();

    @Override
    UserData save(UserData userData);

    @Override
    Optional<UserData> findById(Long userDataId);

    @Override
    void deleteById(Long userDataId);

}
