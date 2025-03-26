package com.petclinic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "issue_description", nullable = false)
    private String issueDescription;

    @Column(name = "issue_type")
    private String issueType;

    @Column(name = "resolved")
    private boolean resolved;

    @Column(name = "resolution")
    private String resolution;

    public Incident() {}

    public Incident(String issueDescription, String issueType, boolean resolved, String resolution) {
        this.issueDescription = issueDescription;
        this.issueType = issueType;
        this.resolved = resolved;
        this.resolution = resolution;
    }

    public int getId() {
        return id;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
