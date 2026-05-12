package com.example.smartcity.institution.service;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.repository.InstitutionRepository;
import com.example.smartcity.report.model.enums.ReportCategory;
import com.example.smartcity.report.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository repository;
    private final ReportRepository reportRepository;

    public InstitutionService(InstitutionRepository repository, ReportRepository reportRepository) {
        this.repository = repository;
        this.reportRepository = reportRepository;
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
    public Institution findByCategory(ReportCategory category) {

        return repository.findByCategory(category)
                .orElse(null);
    }

    public void delete(Long id) {

        Institution institution = getById(id);

        boolean hasReports = reportRepository.existsByInstitutionId(id);

        if (hasReports) {
            throw new RuntimeException("Cannot delete institution with reports");
        }

        repository.delete(institution);
    }

    public Institution getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Institution not found"));
    }

    public Institution update(Long id, Institution institutionDto) {
        Institution institution = getById(id);
        institution.setCategory(institutionDto.getCategory());
        institution.setDescription(institutionDto.getDescription());
        institution.setUrl(institutionDto.getUrl());
        institution.setName(institutionDto.getName());
        return repository.save(institution);
    }
}