package com.example.smartcity.institution.controller;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return service.getAll()
                .stream()
                .toList();
    }

    /**
     * Creates institution.
     */
    @PostMapping
    public Institution create(@Valid @RequestBody Institution dto) {
        return service.create(dto);
    }

    @PostMapping("/{id}")
    public Institution delete(@PathVariable Long id) {
        return service.delete(id);
    }
}