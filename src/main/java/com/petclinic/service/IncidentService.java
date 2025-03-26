package com.petclinic.service;

import com.petclinic.model.Incident;
import com.petclinic.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Incident getIncidentById(int id) {
        return incidentRepository.findById(id).orElse(null);
    }

    public Incident updateIncident(int id, Incident updatedIncident) {
        Optional<Incident> existingIncident = incidentRepository.findById(id);
        if (existingIncident.isPresent()) {
            Incident incident = existingIncident.get();
            incident.setIssueDescription(updatedIncident.getIssueDescription());
            incident.setIssueType(updatedIncident.getIssueType());
            incident.setResolved(updatedIncident.isResolved());
            incident.setResolution(updatedIncident.getResolution());
            return incidentRepository.save(incident);
        }
        return null;
    }

    public void deleteIncident(int id) {
        incidentRepository.deleteById(id);
    }
}
