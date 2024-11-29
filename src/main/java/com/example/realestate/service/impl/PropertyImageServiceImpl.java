package com.example.realestate.service.impl;

import com.example.realestate.exception.ResourceNotFoundException;
import com.example.realestate.model.PropertyImage;
import com.example.realestate.repository.PropertyImageRepository;
import com.example.realestate.service.PropertyImageService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PropertyImageServiceImpl implements PropertyImageService {
    @Autowired
    private PropertyImageRepository propertyImageRepository;

    @Override
    public List<PropertyImage> getImageByPropertyId(Long propertyId) {
        return propertyImageRepository.findByPropertyId(propertyId);
    }

    @Override
    public byte[] getImageData(Long imageId) {
        log.info("Getting image data for id: {}", imageId);
        PropertyImage image = propertyImageRepository.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found: " + imageId));

        try {
            // Lấy đường dẫn đầy đủ của ảnh
            String imagePath = image.getUrl();
            // Đọc file ảnh thành byte array
            return Files.readAllBytes(Paths.get(imagePath));
        } catch (IOException e) {
            log.error("Error reading image file: ", e);
            throw new RuntimeException("Error reading image file", e);
        }
    }
}
