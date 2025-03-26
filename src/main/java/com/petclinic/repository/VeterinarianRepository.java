package com.petclinic.repository;

import com.petclinic.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
	 // ✅ Find by first name (case-insensitive)
    List<Veterinarian> findByFirstNameContainingIgnoreCase(String firstName);

    // ✅ Find by last name (case-insensitive)
    List<Veterinarian> findByLastNameContainingIgnoreCase(String lastName);

    // ✅ Find by specialty
    List<Veterinarian> findBySpecialtyContainingIgnoreCase(String specialty);
}
