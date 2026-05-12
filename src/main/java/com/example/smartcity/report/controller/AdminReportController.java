package com.example.smartcity.report.controller;

import com.example.smartcity.report.dto.ReportResponseDto;
import com.example.smartcity.report.dto.ReportStatusUpdateDto;
import com.example.smartcity.report.dto.ReportUpdateDto;
import com.example.smartcity.report.mapper.ReportMapper;
import com.example.smartcity.report.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/reports")
public class AdminReportController {

    private final ReportService service;

    public AdminReportController(ReportService service) {
        this.service = service;
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

    @PutMapping("/{id}")
    public ReportResponseDto update(
            @PathVariable Long id,
            @Valid @RequestBody ReportUpdateDto dto
    ) {

        return ReportMapper.toDto(
                service.update(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        service.delete(id);
    }
}
