package com.example.smartcity.report.service;

import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.client.institution.InstitutionClient;
import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.dto.ReportUpdateDto;
import com.example.smartcity.report.model.Report;
import com.example.smartcity.report.model.enums.ReportCategory;
import com.example.smartcity.report.model.enums.ReportPriority;
import com.example.smartcity.report.model.enums.ReportStatus;
import com.example.smartcity.report.repository.ReportRepository;
import com.example.smartcity.util.FileStorageService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Business logic for managing reports.
 */
@Service
public class ReportService {

    private final ReportRepository repository;

    private final AiService aiService;

    private final InstitutionService institutionService;

    private final InstitutionClient institutionClient;

    private final FileStorageService fileStorageService;

    public ReportService(
            ReportRepository repository,
            AiService aiService,
            InstitutionService institutionService,
            InstitutionClient institutionClient,
            FileStorageService fileStorageService
    ) {
        this.repository = repository;
        this.aiService = aiService;
        this.institutionService = institutionService;
        this.institutionClient = institutionClient;
        this.fileStorageService = fileStorageService;
    }

    /**
     * Creates report, classifies it,
     * uploads image, and assigns institution.
     */
    @Transactional
    public Report create(ReportCreateDto dto)
            throws IOException {

        // Save image locally
        String imageUrl =
                fileStorageService.save(dto.getImage());

        // Create report
        Report report = new Report();

        // AI classification
        AiResponseDto aiResponse =
                aiService.classify(dto, imageUrl);
        String aiCategory = aiResponse.category();

        ReportCategory category;

        try {
            category = ReportCategory.valueOf(
                    aiCategory.trim().toUpperCase()
            );
        } catch (IllegalArgumentException e) {
            category = ReportCategory.OTHER;
        }
        
        // Institution lookup
        Institution institution = institutionService.findByCategory(category);

        report.setDescription(dto.getDescription());

        report.setCategory(institution.getCategory());
        report.setStatus(ReportStatus.ASSIGNED);

        report.setLatitude(dto.getLatitude());
        report.setLongitude(dto.getLongitude());
        report.setImageUrl(imageUrl);
        report.setSummary(aiResponse.summary());

        ReportPriority priority;

        try {
            priority = ReportPriority.valueOf(
                    aiResponse.priority().toUpperCase()
            );
        } catch (IllegalArgumentException e) {
            priority = ReportPriority.LOW;
        }
        report.setPriority(priority);

        report.setInstitution(institution);
        institutionClient.sendReport(
                institution,
                report
        );

        // Save in database
        Report saved = repository.save(report);

        institutionClient.sendReport(
                institution,
                saved
        );

        return saved;
    }

    /**
     * Returns all reports.
     */
    public List<Report> getAll() {
        return repository.findAll();
    }

    /**
     * Returns report by id.
     */
    public Report getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Report not found"
                        )
                );
    }

    /**
     * Updates report status.
     */
    public Report updateStatus(
            Long id,
            ReportStatus newStatus
    ) {

        Report report = getById(id);

        report.setStatus(newStatus);

        if (newStatus == ReportStatus.RESOLVED) {
            report.setResolvedAt(LocalDateTime.now());
        } else {
            report.setResolvedAt(null);
        }

        return repository.save(report);
    }

    public Report update(
            Long id,
            ReportUpdateDto dto
    ) {

        Report report = getById(id);

        report.setDescription(dto.getDescription());
        report.setCategory(dto.getCategory());
        report.setStatus(dto.getStatus());
        report.setPriority(dto.getPriority());
        report.setLatitude(dto.getLatitude());
        report.setLongitude(dto.getLongitude());
        report.setSummary(dto.getSummary());

        return repository.save(report);
    }

    public void delete(Long id) {
        Report report = getById(id);
        repository.delete(report);
    }
}