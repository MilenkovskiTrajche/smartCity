package com.example.smartcity.report.repository;

import com.example.smartcity.report.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}