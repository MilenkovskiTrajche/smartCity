package com.example.smartcity.report.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ReportCategory {
    WATER,
    FIRE,
    ROAD,
    TRAFFIC,
    WASTE,
    ELECTRICITY,
    PUBLIC_SAFETY,
    OTHER;

    @JsonCreator
    public static ReportCategory from(String value) {
        return ReportCategory.valueOf(value.toUpperCase());
    }
}
