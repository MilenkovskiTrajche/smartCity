package com.example.smartcity.report.service;

import com.example.smartcity.ai.dto.AiResponseDto;
import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.client.institution.InstitutionClient;
import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.service.InstitutionService;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.model.Report;
import com.example.smartcity.report.model.enums.ReportStatus;
import com.example.smartcity.report.repository.ReportRepository;
import com.example.smartcity.util.FileStorageService;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public Report create(ReportCreateDto dto)
            throws IOException {

        // Save image locally
        String imageUrl =
                fileStorageService.save(dto.getImage());

        // AI classification
        AiResponseDto aiResponse =
                aiService.classify(dto, imageUrl);

        // Institution lookup
        Institution institution =
                institutionService.findByCategory(
                        aiResponse.category()
                );

        // Create report
        Report report = new Report();

        report.setDescription(dto.getDescription());

        report.setCategory(
                aiResponse.category()
        );

        report.setStatus(
                ReportStatus.ASSIGNED
        );

        report.setLatitude(dto.getLatitude());

        report.setLongitude(dto.getLongitude());

        report.setImageUrl(imageUrl);

        // Assign institution
        if (institution != null) {

            report.setInstitution(institution);

            institutionClient.sendReport(
                    institution,
                    report
            );
        }

        // Save in database
        return repository.save(report);
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

        Report report = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Report not found"
                        )
                );

        report.setStatus(newStatus);

        return repository.save(report);
    }
}