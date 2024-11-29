package com.example.realestate.controller;

import com.example.realestate.service.PropertyImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
@Slf4j
public class ImageController {
    @Autowired
    private PropertyImageService imageService;
    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long imageId) {
        log.info("Fetching image with id: {}", imageId);
        try {
            byte[] imageData = imageService.getImageData(imageId);
            log.info("Successfully retrieved image data");
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageData);
        } catch (Exception e) {
            log.error("Error fetching image: ", e);
            return ResponseEntity.notFound().build();
        }
    }
}
