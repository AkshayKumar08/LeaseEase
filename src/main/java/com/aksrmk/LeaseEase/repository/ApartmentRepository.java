package com.aksrmk.LeaseEase.repository;

import com.aksrmk.LeaseEase.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, String> {

    Optional<Apartment> findByApartmentId(String id);
}
