package com.aksrmk.LeaseEase.service;

import com.aksrmk.LeaseEase.dto.TenantUpdateRequest;
import com.aksrmk.LeaseEase.model.Tenant;
import com.aksrmk.LeaseEase.repository.TenantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }

    public void addTenant(Tenant tenant) {
        Optional<Tenant> tenantByEmail = tenantRepository.findByEmail(tenant.getEmail());
        if (tenantByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        tenantRepository.save(tenant);
    }

    public void deleteTenant(String tenantId) {
        Optional<Tenant> tenantOptional = tenantRepository.findByTenantId(tenantId);
        Tenant tenant = tenantOptional.orElseThrow(() -> new IllegalStateException("tenant with email Id does not exist"));
        tenantRepository.deleteById(tenant.getId());
    }

    @Transactional
    public void updateTenant(String tenantId, TenantUpdateRequest updateRequest) {
        Tenant existingTenant = tenantRepository.findByTenantId(tenantId)
                .orElseThrow(() -> new EntityNotFoundException("Tenant with id " + tenantId + " does not exists"));

        updateTenantEntity(existingTenant, updateRequest);

        tenantRepository.save(existingTenant);
    }

    private void updateTenantEntity(Tenant existingTenant, TenantUpdateRequest updateRequest) {
        if(updateRequest.getUsername() != null) {
            existingTenant.setUsername(updateRequest.getUsername());
        }
        if(updateRequest.getPassword() != null) {
            existingTenant.setPassword(updateRequest.getPassword());
        }
        if(updateRequest.getFullName() != null) {
            existingTenant.setFullName(updateRequest.getFullName());
        }
        if(updateRequest.getDateOfBirth() != null) {
            existingTenant.setDateOfBirth(updateRequest.getDateOfBirth());
        }
        if(updateRequest.getPhoneNumber() != null) {
            existingTenant.setPhoneNumber(updateRequest.getPhoneNumber());
        }
        if(updateRequest.getAddress() != null) {
            existingTenant.setAddress(updateRequest.getAddress());
        }
        if(updateRequest.getNationality() != null) {
            existingTenant.setNationality(updateRequest.getNationality());
        }
        if(updateRequest.getGender() != null) {
            existingTenant.setGender(updateRequest.getGender());
        }
        if(updateRequest.getLeaseStartDate() != null) {
            existingTenant.setLeaseStartDate(updateRequest.getLeaseStartDate());
        }
        if(updateRequest.getLeaseEndDate() != null) {
            existingTenant.setLeaseEndDate(updateRequest.getLeaseEndDate());
        }
        if(updateRequest.getPetDetails() != null) {
            existingTenant.setPetDetails(updateRequest.getPetDetails());
        }
        if(updateRequest.getVehicleDetails() != null) {
            existingTenant.setVehicleDetails(updateRequest.getVehicleDetails());
        }
        if(updateRequest.getApartment() != null) {
            existingTenant.setApartment(updateRequest.getApartment());
        }
        existingTenant.setUpdatedAt(LocalDateTime.now().toString());
    }
}

