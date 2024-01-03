package com.aksrmk.LeaseEase.repository;

import com.aksrmk.LeaseEase.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, String> {

    Optional<Tenant> findByTenantId(String id);
    Optional<Tenant> findByEmail(String email);
}
