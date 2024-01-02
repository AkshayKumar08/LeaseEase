package com.aksrmk.LeaseEase.repository;

import com.aksrmk.LeaseEase.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {

    Optional<Owner> findByOwnerId(String id);
    Optional<Owner> findByEmail(String email);
}
