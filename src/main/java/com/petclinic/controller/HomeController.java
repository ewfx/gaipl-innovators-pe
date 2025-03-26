package com.petclinic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    // Home page welcome message
    @GetMapping
    public String home() {
        return "Welcome to the PetClinic API!";
    }

    // Health check endpoint
    @GetMapping("/health")
    public String healthCheck() {
        return "API is up and running!";
    }
}
