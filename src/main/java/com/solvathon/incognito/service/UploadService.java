package com.solvathon.incognito.service;

import com.solvathon.incognito.config.FileStorageProperties;
import com.solvathon.incognito.exception.DocumentStorageException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class UploadService {

    private final FileStorageProperties fileStorageProperties;
    private final Path fileStorageLocation;

    public UploadService(FileStorageProperties fileStorageProperties) {
        this.fileStorageProperties = fileStorageProperties;
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new DocumentStorageException(
                    "Could not create the director where the uploaded fuiles will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file, Long userId) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Path fileStorageLocation = Paths.get(fileStorageProperties + "\\" + userId);
            Files.createDirectories(fileStorageLocation);
            Files.copy(file.getInputStream(), fileStorageLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new DocumentStorageException(
                    "Could not store " + file + " Please try again!.", ex);
        }
    }

    public Resource loadFileAsResource(String fileName, Long userId) {
        try {
            Path storageLocation = Paths.get(fileStorageProperties + "\\" + userId);
            Path filePath = storageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (IOException ex) {
            throw new DocumentStorageException("File not found " + fileName, ex);
        }
    }
}
