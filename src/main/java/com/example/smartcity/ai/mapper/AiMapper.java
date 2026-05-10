package com.example.smartcity.ai.mapper;

import com.example.smartcity.ai.dto.AiRequestDto;
import com.example.smartcity.report.dto.ReportCreateDto;

/**
 * Maps internal data to AI request format.
 */
public class AiMapper {

    /**
     * Converts plain description into AI request DTO
     */
    public static AiRequestDto toRequest(ReportCreateDto report, String imagePath) {
        return new AiRequestDto(report.getDescription(), imagePath);
    }
}
