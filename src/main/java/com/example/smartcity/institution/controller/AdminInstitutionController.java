package com.example.smartcity.institution.controller;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/institutions")
public class AdminInstitutionController {

    private final InstitutionService service;

    public AdminInstitutionController(InstitutionService service) {
        this.service = service;
    }

    @PostMapping
    public Institution create(
            @Valid @RequestBody Institution dto
    ) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Institution update(
            @PathVariable Long id,
            @Valid @RequestBody Institution dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}
