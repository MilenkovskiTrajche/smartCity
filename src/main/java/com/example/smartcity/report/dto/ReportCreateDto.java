package com.example.smartcity.report.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

/**
 * Incoming request for creating a report.
 */
@Data
public class ReportCreateDto {

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 500)
    private String description;
    @NotNull(message = "Latitude is required")
    private Double latitude; // Needed for the map pin

    @NotNull(message = "Longitude is required")
    private Double longitude; // Needed for the map pin

    private String imageUrl;
}
