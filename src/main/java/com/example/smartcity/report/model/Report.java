package com.example.smartcity.report.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a city issue reported by a user.
 */
@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String category; // classified by AI

    private String status; // TODO: OPEN, IN_PROGRESS, RESOLVED

    // TODO:
    // - location (lat, lng)
    // - imageUrl
    // - institutionId

    // getters & setters
}