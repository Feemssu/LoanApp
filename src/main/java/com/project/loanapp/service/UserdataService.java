package com.project.loanapp.service;

import com.project.loanapp.domain.Userdata;
import com.project.loanapp.exception.UserdataNotFoundException;
import com.project.loanapp.repository.UserdataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserdataService {

    private final UserdataRepository userdataRepository;

    public List<Userdata> getAllUserdata() {
        return userdataRepository.findAll();
    }

    public Userdata getUserdataById(final Long userdataId) throws UserdataNotFoundException {
        return userdataRepository.findById(userdataId).orElseThrow(UserdataNotFoundException::new);
    }

    public Userdata saveUserdata(final Userdata userdata) {
        return userdataRepository.save(userdata);
    }

    public void deleteUserdataById(final Long userdataId) {
        userdataRepository.deleteById(userdataId);
    }
}
