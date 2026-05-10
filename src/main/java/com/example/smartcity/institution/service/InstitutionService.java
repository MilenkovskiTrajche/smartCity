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
            new Institution(1L, "Vodovod i Kanalizacija", "voda"),
            new Institution(2L, "EVN / ESM", "struja"),
            new Institution(3L, "JP Ulici i Patista", "ulica"),
            new Institution(4L, "JP Ulici i Patista", "dupka"),
            new Institution(5L, "Komunalna Higiena", "otpad")
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
