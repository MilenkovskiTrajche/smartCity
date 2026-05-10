package com.example.smartcity.client.institution;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.report.model.Report;
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
    public void sendReport(Institution institution, Report report) {

        System.out.println("Sending report to institution:");
        System.out.println("Institution: " + institution.name());
        System.out.println("URL: " + institution.url());
        System.out.println("Category: " + report.getCategory());
        System.out.println("Description: " + report.getDescription());

        // TODO:
        // Replace with real HTTP request using WebClient
    }
}
