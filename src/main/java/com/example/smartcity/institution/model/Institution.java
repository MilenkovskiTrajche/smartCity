package com.example.smartcity.institution.model;

import com.example.smartcity.report.model.enums.ReportCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents institution responsible for handling reports.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Supported category:
     * water, electricity, road...
     */
    @Enumerated(EnumType.STRING)
    private ReportCategory category;

    /**
     * Institution responsibility description.
     */
    @Column(length = 1000)
    private String description;

    /**
     * Institution API endpoint.
     */
    private String url;
}