package com.aksrmk.LeaseEase.service;

import com.aksrmk.LeaseEase.dto.OwnerUpdateRequest;
import com.aksrmk.LeaseEase.model.Owner;
import com.aksrmk.LeaseEase.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public void addOwner(Owner owner) {
        Optional<Owner> ownerByEmail = ownerRepository.findByEmail(owner.getEmail());
        if (ownerByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        ownerRepository.save(owner);
    }

    public void deleteOwner(String ownerId) {
        Optional<Owner> ownerOptional = ownerRepository.findByOwnerId(ownerId);
        Owner owner = ownerOptional.orElseThrow(() -> new IllegalStateException("owner with email Id does not exist"));
        ownerRepository.deleteById(owner.getId());
    }

    @Transactional
    public void updateOwner(String ownerId, OwnerUpdateRequest updateRequest) {
        Owner existingOwner = ownerRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Owner with id " + ownerId + " does not exists"));

        updateOwnerEntity(existingOwner, updateRequest);

        ownerRepository.save(existingOwner);
    }

    private void updateOwnerEntity(Owner existingOwner, OwnerUpdateRequest updateRequest) {
        if(updateRequest.getUsername() != null) {
            existingOwner.setUsername(updateRequest.getUsername());
        }
        if(updateRequest.getPassword() != null) {
            existingOwner.setPassword(updateRequest.getPassword());
        }
        if(updateRequest.getFullName() != null) {
            existingOwner.setFullName(updateRequest.getFullName());
        }
        if(updateRequest.getDateOfBirth() != null) {
            existingOwner.setDateOfBirth(updateRequest.getDateOfBirth());
        }
        if(updateRequest.getPhoneNumber() != null) {
            existingOwner.setPhoneNumber(updateRequest.getPhoneNumber());
        }
        if(updateRequest.getAddress() != null) {
            existingOwner.setAddress(updateRequest.getAddress());
        }
        if(updateRequest.getNationality() != null) {
            existingOwner.setNationality(updateRequest.getNationality());
        }
        if(updateRequest.getGender() != null) {
            existingOwner.setGender(updateRequest.getGender());
        }
        existingOwner.setUpdatedAt(LocalDateTime.now().toString());
    }
}

