package com.example.smartcity.report.controller;

import com.example.smartcity.ai.dto.ImageDescriptionResponse;
import com.example.smartcity.ai.service.AiService;
import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.dto.ReportResponseDto;
import com.example.smartcity.report.mapper.ReportMapper;
import com.example.smartcity.report.model.enums.ReportCategory;
import com.example.smartcity.report.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
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

    @PostMapping(value = "/ai-description",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ImageDescriptionResponse generateDescription(
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        return aiService.generateDescription(image);
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return Arrays.stream(ReportCategory.values()).map(ReportCategory::name).toList();
    }
}