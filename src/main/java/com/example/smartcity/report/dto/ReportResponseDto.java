package com.example.smartcity.report.dto;

import com.example.smartcity.report.model.enums.ReportCategory;
import com.example.smartcity.report.model.enums.ReportStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

/**
 * Response returned to client.
 */
@Data
public class ReportResponseDto {

    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private ReportCategory category;

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    private Double latitude;

    private Double longitude;

    private String imageUrl;

    private String institutionName;
}