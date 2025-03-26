package com.petclinic.controller;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.repository.OwnerRepository;
import com.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository; // ✅ Required to fetch owner

    // Get all pets for a specific owner
    @GetMapping("/owner/{ownerId}")
    public List<Pet> getPetsByOwner(@PathVariable Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    // Add a pet to an owner
    @PostMapping("/owner/{ownerId}")
    public Pet addPet(@PathVariable Long ownerId, @RequestBody Pet pet) {
        Optional<Owner> ownerOpt = ownerRepository.findById(ownerId);
        
        if (!ownerOpt.isPresent()) {
            throw new RuntimeException("Owner not found with ID: " + ownerId);
        }

        Owner owner = ownerOpt.get();
        pet.setOwner(owner); // ✅ Assigning correct owner
        
        return petRepository.save(pet);
    }
}
