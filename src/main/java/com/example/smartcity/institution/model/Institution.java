package com.example.smartcity.institution.model;

/**
 * Represents an institution responsible for handling reports.
 *
 * @param category water, electricity, roads
 */
public record Institution(Long id, String name, String category) {

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
}