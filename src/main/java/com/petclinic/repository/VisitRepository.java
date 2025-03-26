package com.petclinic.repository;

import com.petclinic.model.Pet;
import com.petclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
	List<Visit> findByPet_Id(Long petId);
}
