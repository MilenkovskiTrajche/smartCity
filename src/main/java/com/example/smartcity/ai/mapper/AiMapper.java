package com.example.smartcity.ai.mapper;

import com.example.smartcity.ai.dto.AiRequestDto;

/**
 * Maps internal data to AI request format.
 */
public class AiMapper {

    /**
     * Converts plain description into AI request DTO
     */
    public static AiRequestDto toRequest(String description) {
        AiRequestDto dto = new AiRequestDto();
        dto.setDescription(description);
        return dto;
    }
}
