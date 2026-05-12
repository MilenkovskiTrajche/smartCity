package com.example.smartcity.config.cors;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Configures CORS for frontend communication.
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // TODO: restrict in production
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
