package com.example.smartcity.institution.controller;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    private final InstitutionService service;

    public InstitutionController(InstitutionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Institution> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Institution getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }
}