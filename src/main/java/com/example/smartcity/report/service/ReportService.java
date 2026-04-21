package com.example.smartcity.report.service;

import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.model.Report;
import com.example.smartcity.report.repository.ReportRepository;
import org.springframework.stereotype.Service;

/**
 * Business logic for managing reports.
 */
@Service
public class ReportService {

    private final ReportRepository repository;
    private final AiService aiService;

    public ReportService(ReportRepository repository, AiService aiService) {
        this.repository = repository;
        this.aiService = aiService;
    }

    /**
     * Creates report and enriches it using AI classification.
     */
    public Report create(ReportCreateDto dto) {

        AiResponseDto aiResponse = aiService.classify(dto.getDescription());

        Report report = new Report();
        report.setDescription(dto.getDescription());
        report.setCategory(aiResponse.getCategory());
        report.setStatus("OPEN");

        return repository.save(report);
    }
}
