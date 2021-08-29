package com.solvathon.incognito.controller;

import com.solvathon.incognito.model.Packet;
import com.solvathon.incognito.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("v1/api/")
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("userId") Long userId) {
         String fileName = uploadService.storeFile(file, userId);
         Packet<String> packet = new Packet<>(1, "File uploaded successfully", fileName);
         return new ResponseEntity<>(packet, HttpStatus.ACCEPTED);
    }

   @GetMapping(value = "/download/{userId}/{fileName:.+}")
   public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
                                                @PathVariable("userId") Long userId,
                                                HttpServletRequest request) {
      Resource resource = uploadService.loadFileAsResource(fileName, userId);
      String contentType = "application/octet-stream";
      try {
         contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
      }catch (IOException ex) {
         LOGGER.info("Could not determine file type");
      }
      return ResponseEntity.ok()
              .contentType(MediaType.parseMediaType(contentType))
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
              .body(resource);
   }

   @PostMapping(value = "/upload/files")
   public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files,
                                       @RequestParam("userId") Long userId) {
      Arrays.asList(files)
              .stream()
              .map(file -> uploadFile(file, userId));
      return new ResponseEntity<>("Successfully Upload", HttpStatus.ACCEPTED);
   }
}
