package com.example.smartcity.report.model;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.report.model.enums.ReportCategory;
import com.example.smartcity.report.model.enums.ReportPriority;
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

    @Enumerated(EnumType.STRING)
    private ReportCategory category; // classified by AI

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @Enumerated(EnumType.STRING)
    private ReportPriority priority;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    /**
     * AI generated summary.
     */
    @Column(length = 1000)
    private String summary;

    /**
     * Map coordinates.
     */
    private Double latitude;

    private Double longitude;

    /**
     * Relative image path.
     */
    private String imageUrl;
}