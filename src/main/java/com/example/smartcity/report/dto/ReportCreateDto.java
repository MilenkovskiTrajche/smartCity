package com.example.smartcity.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Incoming request for creating a report.
 */
@Data
public class ReportCreateDto {

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 2000)
    private String description;

    private String category;

    /**
     * Map coordinates.
     */
    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    /**
     * Optional image upload.
     */
    private MultipartFile image;
}