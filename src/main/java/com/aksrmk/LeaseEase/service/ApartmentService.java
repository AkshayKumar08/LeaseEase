package com.aksrmk.LeaseEase.service;

import com.aksrmk.LeaseEase.dto.ApartmentUpdateRequest;
import com.aksrmk.LeaseEase.model.Apartment;
import com.aksrmk.LeaseEase.repository.ApartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> getApartments() {
        return apartmentRepository.findAll();
    }

    public void addApartment(Apartment apartment) {
        Optional<Apartment> apartmentAddress = apartmentRepository.findByApartmentId(apartment.getApartmentId());
        if (apartmentAddress.isPresent()) {
            throw new IllegalStateException("address already taken");
        }
        apartmentRepository.save(apartment);
    }

    public void deleteApartment(String apartmentId) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findByApartmentId(apartmentId);
        Apartment apartment = apartmentOptional.orElseThrow(() -> new IllegalStateException("apartment with Id does not exist"));
        apartmentRepository.deleteById(apartment.getApartmentId());
    }

    @Transactional
    public void updateApartment(String apartmentId, ApartmentUpdateRequest updateRequest) {
        Apartment existingApartment = apartmentRepository.findByApartmentId(apartmentId)
                .orElseThrow(() -> new EntityNotFoundException("Apartment with id " + apartmentId + " does not exists"));
        updateApartmentEntity(existingApartment, updateRequest);
        apartmentRepository.save(existingApartment);
    }

    private void updateApartmentEntity(Apartment existingApartment, ApartmentUpdateRequest updateRequest) {
        if(updateRequest.getAddress() != null) {
            existingApartment.setAddress(updateRequest.getAddress());
        }
        if(updateRequest.getNumberOfRooms() != null) {
            existingApartment.setNumberOfRooms(updateRequest.getNumberOfRooms());
        }
        if(updateRequest.getNumberOfBathrooms() != null) {
            existingApartment.setNumberOfBathrooms(updateRequest.getNumberOfBathrooms());
        }
        if(updateRequest.getFurnished() != null) {
            existingApartment.setFurnished(updateRequest.getFurnished());
        }
        if(updateRequest.getSquareFootage() != null) {
            existingApartment.setSquareFootage(updateRequest.getSquareFootage());
        }
        if(updateRequest.getOwner() != null) {
            existingApartment.setOwner(updateRequest.getOwner());
        }
        if(updateRequest.getTenants() != null) {
            existingApartment.setTenant(updateRequest.getTenants());
        }
    }
}

