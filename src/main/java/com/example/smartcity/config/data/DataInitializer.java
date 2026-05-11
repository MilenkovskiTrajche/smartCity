package com.example.smartcity.config.data;

import com.example.smartcity.institution.model.Institution;
import com.example.smartcity.institution.repository.InstitutionRepository;
import com.example.smartcity.report.model.enums.ReportCategory;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final InstitutionRepository repository;

    public DataInitializer(InstitutionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String @NonNull ... args) {

        if (repository.count() > 0) return; // prevent duplicates

        repository.save(new Institution(
                null,
                "ЈП Водовод и Канализација Скопје",
                ReportCategory.WATER,
                "Handles water supply and sewage issues in Skopje",
                "https://vodovod-skopje.mk"
        ));

        repository.save(new Institution(
                null,
                "ериторијална противпожарна единица – Скопје",
                ReportCategory.FIRE,
                "Fire incidents, smoke, explosions, emergency response",
                "https://dzs.gov.mk"
        ));

        repository.save(new Institution(
                null,
                "ЕВН Македонија",
                ReportCategory.ELECTRICITY,
                "Electricity distribution and maintenance company",
                "https://evn.mk"
        ));

        repository.save(new Institution(
                null,
                "ЈП Улици и Патишта",
                ReportCategory.ROAD,
                "Road maintenance and infrastructure repair",
                "https://skopje.gov.mk"
        ));

        repository.save(new Institution(
                null,
                "Комунална Хигиена",
                ReportCategory.WASTE,
                "Waste collection and city sanitation services",
                "https://khigiena.mk"
        ));

        repository.save(new Institution(
                null,
                "Министерство за внатрешни работи",
                ReportCategory.PUBLIC_SAFETY,
                "Public safety and emergency response",
                "https://mvr.gov.mk"
        ));

        repository.save(new Institution(
                null,
                "СВР Скопје (МВР) – traffic enforcement",
                ReportCategory.TRAFFIC,
                "Traffic accidents, Road control, Signals, congestion",
                "https://mvr.gov.mk"
        ));

        repository.save(new Institution(
                null,
                "СВР Скопје (МВР) – traffic enforcement",
                ReportCategory.TRAFFIC,
                "Traffic accidents, Road control, Signals, congestion",
                "https://mvr.gov.mk"
        ));
    }
}
