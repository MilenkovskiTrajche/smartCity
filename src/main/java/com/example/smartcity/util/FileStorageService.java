package com.example.smartcity.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

/**
 * Handles local image storage.
 */
@Service
public class FileStorageService {

    @Value("${app.base.url}")
    private String BASE_URL;
    private static final String UPLOAD_DIR =
            System.getProperty("user.dir") + "/uploads/reports/";

    /**
     * Saves image locally and returns relative path.
     */
    public String save(MultipartFile file)
            throws IOException {

        if (file == null || file.isEmpty()) {
            return null;
        }

        Path uploadPath =
                Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filename =
                UUID.randomUUID() + "_" +
                        file.getOriginalFilename();

        Path filePath =
                uploadPath.resolve(filename);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING
        );
        return BASE_URL + "/uploads/reports/" + filename;
    }
}