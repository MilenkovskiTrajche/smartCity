package com.example.smartcity.ai.dto;

/**
 * Request sent to AI analysis service.
 */
public record AiRequestDto(

        String description,

        String category,

        String imageUrl

) {
}