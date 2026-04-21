package com.example.smartcity.client.institution;

import org.springframework.stereotype.Component;

/**
 * Mock client for sending reports to institutions.
 * In real system this would call external API.
 */
@Component
public class InstitutionClient {

    /**
     * Simulates sending report to institution.
     */
    public void sendReport(String category, String description) {

        // TODO: Replace with real HTTP call in future

        System.out.println("Sending report to institution:");
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);

        // Simulate delay or success if needed
    }
}
