package com.example.smartcity.report.dto;

import com.example.smartcity.report.model.enums.ReportStatus;
import lombok.Data;

/**
 * Response returned to client.
 */
@Data
public class ReportResponseDto {

    private Long id;

    private String description;

    private String category;

    private ReportStatus status;

    private Double latitude;

    private Double longitude;

    private String imageUrl;

    private String institutionName;
}