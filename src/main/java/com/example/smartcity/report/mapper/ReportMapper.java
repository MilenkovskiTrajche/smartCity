package com.example.smartcity.report.mapper;

import com.example.smartcity.report.dto.ReportResponseDto;
import com.example.smartcity.report.model.Report;

/**
 * Handles mapping between Report entity and DTOs.
 */
public class ReportMapper {

    public static ReportResponseDto toDto(Report report) {
        ReportResponseDto dto = new ReportResponseDto();
        dto.setId(report.getId());
        dto.setDescription(report.getDescription());
        dto.setCategory(report.getCategory());
        dto.setStatus(report.getStatus());
        return dto;
    }
}
