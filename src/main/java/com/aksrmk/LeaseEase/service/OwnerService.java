package com.aksrmk.LeaseEase.service;

import com.aksrmk.LeaseEase.model.Owner;
import com.aksrmk.LeaseEase.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }
}
