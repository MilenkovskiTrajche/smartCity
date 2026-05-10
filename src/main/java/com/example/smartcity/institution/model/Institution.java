package com.example.smartcity.institution.model;

/**
 * Represents an institution responsible for handling reports.
 */
public record Institution(

        Long id,

        String name,

        String category,

        String description,

        String url

) {
}