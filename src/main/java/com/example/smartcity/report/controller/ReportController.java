package com.example.smartcity.report.controller;

import com.example.smartcity.report.dto.ReportCreateDto;
import com.example.smartcity.report.dto.ReportResponseDto;
import com.example.smartcity.report.mapper.ReportMapper;
import com.example.smartcity.report.service.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

/**
 * REST endpoints for reports.
 */
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    /**
     * Create new report
     */
    @PostMapping
    public ReportResponseDto create(@Valid @RequestBody ReportCreateDto dto) {
        return ReportMapper.toDto(service.create(dto));
    }
}