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

    /**
     * Creates report, classifies it, and assigns institution.
     */
    public Report create(ReportCreateDto dto) {

        // 1. AI classification
        AiResponseDto aiResponse = aiService.classify(dto.getDescription());

        // 2. Find institution
        Institution institution =
                institutionService.findByCategory(aiResponse.getCategory());

        // 3. Create report
        Report report = new Report();
        report.setDescription(dto.getDescription());
        report.setCategory(aiResponse.getCategory());
        report.setStatus(ReportStatus.ASSIGNED);

        if (institution != null) {
            report.setInstitutionName(institution.name());
        }

        return repository.save(report);
    }
}
