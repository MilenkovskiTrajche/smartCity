package com.example.smartcity.institution.service;

import com.example.smartcity.institution.model.Institution;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides institution data (mocked).
 */
@Service
public class InstitutionService {

    private final List<Institution> institutions = List.of(
            new Institution(1L, "Water Supply", "water"),
            new Institution(2L, "Electric Company", "electricity"),
            new Institution(3L, "City Roads", "road")
    );

    /**
     * Finds institution by category.
     */
    public Institution findByCategory(String category) {
        return institutions.stream()
                .filter(i -> i.category().equalsIgnoreCase(category))
                .findFirst()
                .orElse(null);
    }
}
