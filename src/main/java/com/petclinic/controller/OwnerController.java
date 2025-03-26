package com.petclinic.controller;

import com.petclinic.model.Owner;
import com.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository repository;

    // Get all owners
    @GetMapping
    public List<Owner> getAllOwners() {
        return repository.findAll();
    }

    // Get owner by ID
    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Add a new owner
    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return repository.save(owner);
    }

    // Update an existing owner
    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner updatedOwner) {
        return repository.findById(id).map(owner -> {
            owner.setFirstName(updatedOwner.getFirstName());
            owner.setLastName(updatedOwner.getLastName());
            owner.setAddress(updatedOwner.getAddress());
            owner.setCity(updatedOwner.getCity());
            owner.setTelephone(updatedOwner.getTelephone());
            return repository.save(owner);
        }).orElse(null);
    }

    // Delete an owner
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
