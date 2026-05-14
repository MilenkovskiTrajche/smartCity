package com.example.smartcity.report.mapper;

import com.example.smartcity.report.dto.ReportResponseDto;
import com.example.smartcity.report.model.Report;

/**
 * Handles mapping between Report entity and DTOs.
 */
public class ReportMapper {

    public static ReportResponseDto toDto(Report report) {

        ReportResponseDto dto =
                new ReportResponseDto();

        dto.setId(report.getId());
        dto.setDescription(report.getSummary());
        dto.setCategory(report.getCategory());
        dto.setStatus(report.getStatus());

        dto.setLatitude(report.getLatitude());
        dto.setLongitude(report.getLongitude());

        dto.setImageUrl(report.getImageUrl());

        if (report.getInstitution() != null) {
            dto.setInstitutionName(
                    report.getInstitution().getName()
            );
        }

        dto.setCreatedAt(report.getCreatedAt());
        dto.setUpdatedAt(report.getUpdatedAt());
        dto.setResolvedAt(report.getResolvedAt());

        return dto;
    }
}