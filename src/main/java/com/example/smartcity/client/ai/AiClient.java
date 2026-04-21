package com.example.smartcity.client.ai;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AiClient {

    private final WebClient webClient;

    public AiClient(WebClient aiWebClient) {
        this.webClient = aiWebClient;
    }

    /**
     * Calls external AI service (Python)
     * Sends image/text and receives classification
     */
    public String classify(String input) {
        return webClient.post()
                .uri("/classify")
                .bodyValue(input)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}