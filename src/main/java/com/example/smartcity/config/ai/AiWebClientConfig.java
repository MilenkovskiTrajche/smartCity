package com.example.smartcity.config.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AiWebClientConfig {

    @Value("${AI_BASE_URL:http://127.0.0.1:8000}") // This reads from .env and has a fallback
    private String aiBaseUrl;

    @Bean
    public WebClient aiWebClient() {
        return WebClient.builder()
                .baseUrl(aiBaseUrl)
                .build();
    }
}