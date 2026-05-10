package com.example.smartcity.institution.service;

import com.example.smartcity.institution.model.Institution;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsible for institution management.
 * <p>
 * Currently uses mock in-memory data.
 */
@Service
public class InstitutionService {

    private final List<Institution> institutions = List.of(

            new Institution(
                    1L,
                    "Water Supply",
                    "water",
                    "Handles water supply and leak issues.",
                    "http://localhost:9001/institutions/water"
            ),

            new Institution(
                    2L,
                    "Electric Company",
                    "electricity",
                    "Responsible for electricity infrastructure.",
                    "http://localhost:9002/institutions/electricity"
            ),

            new Institution(
                    3L,
                    "City Roads",
                    "road",
                    "Handles road damage and traffic infrastructure.",
                    "http://localhost:9003/institutions/roads"
            )
    );

    /**
     * Returns all institutions.
     */
    public List<Institution> getAll() {
        return institutions;
    }

    /**
     * Finds institution by category.
     */
    public Institution findByCategory(String category) {
        return institutions.stream()
                .filter(i -> i.category().equalsIgnoreCase(category))
                .findFirst()
                .orElse(null);
    }

    /**
     * Returns supported categories.
     */
    public List<String> getCategories() {
        return institutions.stream()
                .map(Institution::category)
                .distinct()
                .toList();
    }
}