package com.example.smartcity.report.controller;

import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.dto.ReportResponseDto;
import com.example.smartcity.report.dto.ReportStatusUpdateDto;
import com.example.smartcity.report.mapper.ReportMapper;
import com.example.smartcity.report.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * REST endpoints for reports.
 */
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;
    private final AiService aiService;

    public ReportController(ReportService service, AiService aiService) {
        this.service = service;
        this.aiService = aiService;
    }

    /**
     * Create new report.
     */
    @PostMapping
    public ReportResponseDto create(
            @Valid @ModelAttribute ReportCreateDto dto) throws IOException {

        return ReportMapper.toDto(
                service.create(dto)
        );
    }

    /**
     * Returns all reports.
     */
    @GetMapping
    public List<ReportResponseDto> getAll() {

        return service.getAll()
                .stream()
                .map(ReportMapper::toDto)
                .toList();
    }

    /**
     * Returns report by id.
     */
    @GetMapping("/{id}")
    public ReportResponseDto getById(
            @PathVariable Long id) {

        return ReportMapper.toDto(
                service.getById(id)
        );
    }

    @PutMapping("/{id}/status")
    public ReportResponseDto updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody
            ReportStatusUpdateDto dto
    ) {

        return ReportMapper.toDto(
                service.updateStatus(
                        id,
                        dto.getStatus()
                )
        );
    }


    @PostMapping(value = "/ai-description",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String generateDescription(
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        return aiService.generateDescription(image);
    }
}