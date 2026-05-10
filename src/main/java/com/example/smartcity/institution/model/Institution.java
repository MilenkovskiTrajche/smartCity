package com.example.smartcity.institution.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents institution responsible for handling reports.
 */
@Data
@Entity
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Supported category:
     * water, electricity, road...
     */
    private String category;

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