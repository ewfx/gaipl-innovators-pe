package com.petclinic.controller;

import com.petclinic.model.Veterinarian;
import com.petclinic.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarians") // Base URL
public class VeterinarianController {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    // 1️⃣ Get all veterinarians
    @GetMapping
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    // 2️⃣ Get a veterinarian by ID
    @GetMapping("/{id}")
    public Optional<Veterinarian> getVeterinarianById(@PathVariable Long id) {
        return veterinarianRepository.findById(id);
    }

    // 3️⃣ Add a new veterinarian
    @PostMapping
    public Veterinarian addVeterinarian(@RequestBody Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    // 4️⃣ Update an existing veterinarian
    @PutMapping("/{id}")
    public Veterinarian updateVeterinarian(@PathVariable Long id, @RequestBody Veterinarian updatedVeterinarian) {
        return veterinarianRepository.findById(id).map(vet -> {
            vet.setFirstName(updatedVeterinarian.getFirstName());
            vet.setLastName(updatedVeterinarian.getLastName());
            vet.setSpecialty(updatedVeterinarian.getSpecialty());
            return veterinarianRepository.save(vet);
        }).orElseGet(() -> {
            updatedVeterinarian.setId(id);
            return veterinarianRepository.save(updatedVeterinarian);
        });
    }

    // 5️⃣ Delete a veterinarian
    @DeleteMapping("/{id}")
    public void deleteVeterinarian(@PathVariable Long id) {
        veterinarianRepository.deleteById(id);
    }
}
