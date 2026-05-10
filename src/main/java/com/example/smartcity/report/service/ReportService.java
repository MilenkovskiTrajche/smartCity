package com.example.smartcity.report.service;

import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.model.Report;
import com.example.smartcity.report.model.enums.ReportStatus;
import com.example.smartcity.report.repository.ReportRepository;
import org.springframework.stereotype.Service;

/**
 * Business logic for managing reports.
 */

@Service
public class ReportService {

    private final ReportRepository repository;
    private final AiService aiService;
    private final InstitutionService institutionService;

    public ReportService(ReportRepository repository,
                         AiService aiService,
                         InstitutionService institutionService) {
        this.repository = repository;
        this.aiService = aiService;
        this.institutionService = institutionService;
    }

    public Report create(ReportCreateDto dto) {

        // 1. AI classification (Description -> Category & Priority)
        AiResponseDto aiResponse = aiService.classify(dto.getDescription());

        // 2. Find institution based on the AI-detected category
        Institution institution =
                institutionService.findByCategory(aiResponse.getCategory());

        // 3. Create report with all the "Smart City" fields
        Report report = new Report();
        report.setDescription(dto.getDescription());

        // Data from AI
        report.setCategory(aiResponse.getCategory());
        report.setPriority(aiResponse.getPriority()); // You added this to the model

        // Data from Frontend DTO
        report.setLatitude(dto.getLatitude());     // For the map pin
        report.setLongitude(dto.getLongitude());   // For the map pin
        report.setImageUrl(dto.getImageUrl());     // For the evidence photo

        report.setStatus(ReportStatus.ASSIGNED);

        if (institution != null) {
            report.setInstitutionName(institution.getName());
            report.setInstitutionId(institution.getId()); // Linking for later tracking
        }

        return repository.save(report);
    }
}