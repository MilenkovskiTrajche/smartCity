package com.example.smartcity.institution.service;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository repository;

    public InstitutionService(InstitutionRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns all institutions.
     */
    public List<Institution> getAll() {
        return repository.findAll();
    }

    /**
     * Creates institution.
     */
    public Institution create(Institution dto) {

        Institution institution = new Institution();

        institution.setName(dto.getName());
        institution.setCategory(dto.getCategory());
        institution.setDescription(dto.getDescription());
        institution.setUrl(dto.getUrl());

        return repository.save(institution);
    }

    /**
     * Finds institution by category.
     */
    public Institution findByCategory(String category) {

        return repository.findByCategory(category)
                .orElse(null);
    }

    public Institution delete(Long id) {
        Institution institution = repository.findById(id).orElse(null);

        if (institution != null) {
            repository.delete(institution);
            return institution;
        } else {
            return null;
        }
    }
}