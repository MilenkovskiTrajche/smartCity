package com.example.smartcity.report.dto;

import com.example.smartcity.report.model.enums.ReportCategory;
import com.example.smartcity.report.model.enums.ReportPriority;
import com.example.smartcity.report.model.enums.ReportStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReportUpdateDto {

    @NotBlank
    private String description;

    private ReportCategory category;

    private ReportStatus status;

    private ReportPriority priority;

    private Double latitude;

    private Double longitude;

    private String summary;
}