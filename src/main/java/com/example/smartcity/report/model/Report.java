package com.example.smartcity.report.model;

import com.example.smartcity.report.model.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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

    private String category; // classified by AI e.g., "voda", "struja", "dupka"

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    private String institutionName; // The name suggested by AI (e.g., "EVN")

    private String priority; // "HIGH", "MEDIUM", "LOW" - returned by AI

    private String imageUrl; // Path or URL to the uploaded image

    // Location data for the map pins
    private Double latitude;
    private Double longitude;

    private Long institutionId; // To link with the Institution entity later


//    @Enumerated(EnumType.STRING)
//    private ReportStatus status = ReportStatus.OPEN;

    private LocalDateTime createdAt = LocalDateTime.now(); // Record when it was first reported

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
// TODO:
    // - location (lat, lng)
    // - imageUrl
    // - institutionId

    // getters & setters
}