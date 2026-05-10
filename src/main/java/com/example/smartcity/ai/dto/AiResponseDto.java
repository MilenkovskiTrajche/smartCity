package com.example.smartcity.ai.dto;

/**
 * AI analysis result.
 */
public record AiResponseDto(

        String category,

        String summary,

        String priority,

        String institutionCategory,

        Double confidence,

        Boolean categoryMatch

) {
}