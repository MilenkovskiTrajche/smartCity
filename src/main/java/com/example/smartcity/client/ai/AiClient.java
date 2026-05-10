package com.example.smartcity.client.ai;

import com.example.smartcity.ai.dto.AiRequestDto;
import com.example.smartcity.ai.dto.AiResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Responsible for communication with external AI service (Python).
 */
@Component
public class AiClient {

    private final WebClient webClient;

    public AiClient(WebClient aiWebClient) {
        this.webClient = aiWebClient;
    }

    /**
     * Calls AI service endpoint.
     */
    public AiResponseDto classify(AiRequestDto request) {
        return webClient.post()
                .uri("/analyze")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AiResponseDto.class)
                .block();
    }
}