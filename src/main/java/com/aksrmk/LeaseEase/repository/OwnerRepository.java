package com.aksrmk.LeaseEase.repository;

import com.aksrmk.LeaseEase.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {

}
