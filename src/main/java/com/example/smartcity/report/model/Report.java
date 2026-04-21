package com.example.smartcity.report.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String category; // AI classified

    // TODO: add location, imageUrl, status, institutionId

}