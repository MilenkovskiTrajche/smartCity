package com.example.smartcity.ai.service;

import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.mapper.AiMapper;
import com.example.smartcity.client.ai.AiClient;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.util.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Handles business logic related to AI classification.
 */
@Service
public class AiService {

    private final AiClient aiClient;
    private final FileStorageService fileStorageService;

    public AiService(AiClient aiClient, FileStorageService fileStorageService) {
        this.aiClient = aiClient;
        this.fileStorageService = fileStorageService;
    }

    /**
     * Sends data to AI and returns classification result.
     */
    public AiResponseDto classify(ReportCreateDto dto, String imagePath) {
        return aiClient.classify(AiMapper.toRequest(dto, imagePath));
    }

    public String generateDescription(
            MultipartFile image
    ) throws IOException {
        String imagePath = fileStorageService.save(image);

        return aiClient.generateDescription(imagePath);
    }

}
