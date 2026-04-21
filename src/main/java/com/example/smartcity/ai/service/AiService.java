package com.example.smartcity.ai.service;

import com.example.smartcity.client.ai.AiClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final AiClient aiClient;

    public AiService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    /**
     * Business logic for AI classification
     */
    public String classifyReport(String input) {
        return aiClient.classify(input);
    }
}
