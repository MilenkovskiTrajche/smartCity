package com.example.smartcity.ai.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Response received from AI service.
 * Represents classification result.
 */
@Setter
@Getter
public class AiResponseDto {

    private String category;

    private Double confidence; // optional

    private String priority; // AI should decide if it's HIGH/MEDIUM/LOW

    private String institution; // AI suggests who handles this (e.g., EVN)

}