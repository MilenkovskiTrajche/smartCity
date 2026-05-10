package com.example.smartcity.institution.controller;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoints for institutions.
 */
@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    private final InstitutionService service;

    public InstitutionController(InstitutionService service) {
        this.service = service;
    }

    /**
     * Returns all institutions.
     */
    @GetMapping
    public List<Institution> getAll() {
        return service.getAll();
    }

    /**
     * Returns supported categories.
     */
    @GetMapping("/categories")
    public List<String> getCategories() {
        return service.getCategories();
    }
}