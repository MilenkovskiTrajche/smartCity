package com.example.smartcity.ai.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Request sent to AI service.
 * Can be extended later with:
 * - image (base64 or URL)
 * - location
 */
@Setter
@Getter
public class AiRequestDto {

    private String description;

    private String imageUrl;

    // Constructor for easy use in Service
    public AiRequestDto(String description, String imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public AiRequestDto() {

    }
}