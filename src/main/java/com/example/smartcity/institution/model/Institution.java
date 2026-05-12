package com.example.smartcity.institution.model;

import com.example.smartcity.report.model.enums.ReportCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String name;

    /**
     * Supported category:
     * water, electricity, road...
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private ReportCategory category;

    /**
     * Institution responsibility description.
     */
    @NotBlank
    @Column(length = 1000)
    private String description;

    /**
     * Institution API endpoint.
     */
    @NotBlank
    private String url;
}