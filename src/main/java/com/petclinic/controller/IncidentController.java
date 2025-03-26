package com.petclinic.controller;

import com.petclinic.model.Incident;
import com.petclinic.service.IncidentPredictor;
import com.petclinic.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/incidents") // 🔹 Change base URL to include `/api`
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to access backend
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private IncidentPredictor incidentPredictor; // 🔹 Inject the predictor service

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.createIncident(incident);
    }

    @GetMapping("/{id}")
    public Incident getIncidentById(@PathVariable int id) {
        return incidentService.getIncidentById(id);
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable int id, @RequestBody Incident incident) {
        return incidentService.updateIncident(id, incident);
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable int id) {
        incidentService.deleteIncident(id);
    }

    // 🔥 ADD THIS: AI Prediction API
    @GetMapping("/predict")
    public ResponseEntity<String> predictIncident(@RequestParam String issue) {
        String recommendation = incidentPredictor.predictIncident(issue);
        Map<String, String> response = new HashMap<>();
        response.put("recommendation", recommendation);
        return ResponseEntity.ok(recommendation);
    }
}
