package com.example.smartcity.report.model;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.report.model.enums.ReportStatus;
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

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    // TODO:
    // - location (lat, lng)
    // - imageUrl
    // - institutionId

    // getters & setters
}