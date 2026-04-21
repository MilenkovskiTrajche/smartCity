package com.example.smartcity.config.json;

import com.fasterxml.jackson.databind.*;
import org.springframework.context.annotation.*;

/**
 * Custom JSON configuration.
 */
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .findAndRegisterModules()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}