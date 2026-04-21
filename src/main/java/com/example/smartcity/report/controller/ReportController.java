package com.example.smartcity.report.controller;

import com.example.smartcity.report.model.Report;
import com.example.smartcity.report.service.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    /**
     * Create report endpoint
     */
    @PostMapping
    public Report create(@RequestBody String description) {
        return service.createReport(description);
    }
}