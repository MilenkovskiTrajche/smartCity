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

    // TODO: add image field (Multipart or base64)

}