package com.example.smartcity.report.dto;

import com.example.smartcity.report.model.enums.ReportStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Request for updating report status.
 */
@Data
public class ReportStatusUpdateDto {

    @NotNull
    private ReportStatus status;
}