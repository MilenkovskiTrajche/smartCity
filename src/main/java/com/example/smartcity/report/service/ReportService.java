package com.example.smartcity.report.service;

import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.report.model.Report;
import com.example.smartcity.report.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ReportRepository repository;
    private final AiService aiService;

    public ReportService(ReportRepository repository, AiService aiService) {
        this.repository = repository;
        this.aiService = aiService;
    }

    /**
     * Creates report and classifies it using AI
     */
    public Report createReport(String description) {
        String category = aiService.classifyReport(description);

        Report report = new Report();
        report.setDescription(description);
        report.setCategory(category);

        return repository.save(report);
    }
}
