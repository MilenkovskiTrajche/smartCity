package com.example.smartcity.report.dto;

import com.example.smartcity.report.model.enums.ReportStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Response returned to client.
 */
@Data
public class ReportResponseDto {

    private Long id;
    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 500)
    private String description;
    private String category;
    private ReportStatus status;
    @NotNull(message = "Latitude is required")
    private Double latitude;
    @NotNull(message = "Longitude is required")
    private Double longitude;
    private String imageUrl;
    private String priority;
    private String institutionName;
}
