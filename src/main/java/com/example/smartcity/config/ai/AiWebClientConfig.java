package com.example.smartcity.config.ai;

import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AiWebClientConfig {

    @Bean
    public WebClient aiWebClient() {
        return WebClient.builder()
                .baseUrl(System.getenv("AI_BASE_URL"))
                .build();
    }
}