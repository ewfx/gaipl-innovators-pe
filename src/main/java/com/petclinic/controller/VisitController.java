package com.petclinic.controller;

import com.petclinic.model.Visit;
import com.petclinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;

    // 1️⃣ Get all visits
    @GetMapping
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    // 2️⃣ Get a visit by ID
    @GetMapping("/{id}")
    public Optional<Visit> getVisitById(@PathVariable Long id) {
        return visitRepository.findById(id);
    }

    // 3️⃣ Add a new visit
    @PostMapping
    public Visit addVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }

    // 4️⃣ Update an existing visit
    @PutMapping("/{id}")
    public Visit updateVisit(@PathVariable Long id, @RequestBody Visit updatedVisit) {
        return visitRepository.findById(id).map(visit -> {
            visit.setDate(updatedVisit.getDate());
            visit.setDescription(updatedVisit.getDescription());
            visit.setPet(updatedVisit.getPet());
            return visitRepository.save(visit);
        }).orElseGet(() -> {
            updatedVisit.setId(id);
            return visitRepository.save(updatedVisit);
        });
    }

    // 5️⃣ Delete a visit
    @DeleteMapping("/{id}")
    public void deleteVisit(@PathVariable Long id) {
        visitRepository.deleteById(id);
    }
}
