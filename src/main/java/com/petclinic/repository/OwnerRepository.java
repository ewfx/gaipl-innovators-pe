package com.petclinic.repository;

import com.petclinic.model.Owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByLastNameContainingIgnoreCase(String lastName);

}


