package com.petclinic.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class IncidentPredictor {
    
    private static final String HUGGING_FACE_API_URL = "https://api-inference.huggingface.co/models/mistralai/Mistral-7B-Instruct-v0.1";
    private static final String API_TOKEN = "${}";  // Replace with your actual token

    public String predictIncident(String issueDescription) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + API_TOKEN); // Set API key

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("inputs", "Predict incident cause and recommend fix: " + issueDescription);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(HUGGING_FACE_API_URL, HttpMethod.POST, requestEntity, String.class);

            // ✅ Parse JSON response properly
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.getBody());

            if (root.isArray() && root.size() > 0) {
                return root.get(0).get("generated_text").asText(); // ✅ Extracts the actual prediction
            }

            return "No prediction available.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error predicting incident: " + e.getMessage();
        }
    }
}
