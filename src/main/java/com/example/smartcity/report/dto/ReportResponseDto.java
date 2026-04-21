package com.example.smartcity.report.dto;

import lombok.Data;

/**
 * Response returned to client.
 */
@Data
public class ReportResponseDto {

    private Long id;
    private String description;
    private String category;
    private String status;
}
