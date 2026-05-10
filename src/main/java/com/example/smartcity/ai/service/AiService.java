package com.example.smartcity.ai.service;

import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.mapper.AiMapper;
import com.example.smartcity.client.ai.AiClient;
import com.example.smartcity.report.dto.ReportCreateDto;
import org.springframework.stereotype.Service;

/**
 * Handles business logic related to AI classification.
 */
@Service
public class AiService {

    private final AiClient aiClient;

    public AiService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    /**
     * Sends data to AI and returns classification result.
     */
    public AiResponseDto classify(ReportCreateDto dto, String imagePath) {
        return aiClient.classify(AiMapper.toRequest(dto, imagePath));
    }
}
