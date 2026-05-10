package com.example.smartcity.institution.repository;

import com.example.smartcity.institution.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstitutionRepository
        extends JpaRepository<Institution, Long> {

    Optional<Institution> findByCategory(String category);
}