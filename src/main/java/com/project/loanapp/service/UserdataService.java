package com.project.loanapp.service;

import com.project.loanapp.domain.Userdata;
import com.project.loanapp.exception.UserdataNotFoundException;
import com.project.loanapp.repository.UserdataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Userdata getUserdataByPesel(final String pesel) throws UserdataNotFoundException {
        return userdataRepository.findByPesel(pesel).orElseThrow(UserdataNotFoundException::new);
    }

    public Userdata getUserdataByPhoneNumber(final String phoneNumber) throws UserdataNotFoundException {
        return userdataRepository.findByPhoneNumber(phoneNumber).orElseThrow(UserdataNotFoundException::new);
    }

    public boolean isPeselUnique(String pesel) {
        Optional<Userdata> existingPesel = userdataRepository.findByPesel(pesel);
        return existingPesel.isEmpty();
    }

    public boolean isPhoneUnique(String phoneNumber) {
        Optional<Userdata> existingPhoneNumber = userdataRepository.findByPhoneNumber(phoneNumber);
        return existingPhoneNumber.isEmpty();
    }

    public List<Userdata> getAllUserdataByFirstname(final String firstname) {
        return userdataRepository.findAllByFirstname(firstname);
    }

    public List<Userdata> getAllUserdataByLastname(final String lastname) {
        return userdataRepository.findAllByLastname(lastname);
    }
}
