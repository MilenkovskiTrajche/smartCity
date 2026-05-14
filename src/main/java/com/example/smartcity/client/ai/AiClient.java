package com.example.smartcity.client.ai;

import com.example.smartcity.ai.dto.AiRequestDto;
import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.dto.ImageDescriptionRequest;
import com.example.smartcity.ai.dto.ImageDescriptionResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

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
                .timeout(Duration.ofSeconds(5))
                .doOnError(e -> {
                    System.out.println("AI ERROR:");
                    e.printStackTrace();
                })
                .block();
    }

    public ImageDescriptionResponse generateDescription(String imagePath) {

        return webClient.post()
                .uri("/generate-description")
                .bodyValue(new ImageDescriptionRequest(imagePath))
                .retrieve()
                .bodyToMono(ImageDescriptionResponse.class)
                .timeout(Duration.ofSeconds(5))
                .doOnError(e -> {
                    System.out.println("AI ERROR:");
                    e.printStackTrace();
                })
                .block();
    }
}
