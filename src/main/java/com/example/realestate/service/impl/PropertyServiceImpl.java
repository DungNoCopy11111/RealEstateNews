package com.example.realestate.service.impl;

import com.example.realestate.converter.PropertyConverter;
import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.dtos.request.CreatePostRequest;
import com.example.realestate.enums.*;
import com.example.realestate.model.Property;
import com.example.realestate.model.PropertyAddress;
import com.example.realestate.model.PropertyImage;
import com.example.realestate.repository.PropertyRepository;
import com.example.realestate.service.PropertyService;
import jakarta.el.PropertyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream()
                .map(property -> propertyConverter.toDTO(property))  // Sử dụng phương thức không phải static
                .collect(Collectors.toList());
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public List<PropertyDTO> getRecentProperties() {
        List<Property> properties = propertyRepository.findTop10ByOrderByCreatedAtDesc();
        return properties.stream()
                .map(property -> propertyConverter.toDTO(property))
                .collect(Collectors.toList());
    }

    @Override
    public Property approveProperty(Long id) throws PropertyNotFoundException {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new PropertyNotFoundException("Property not found with id: " + id));
        property.setStatus(1L);
        property.setUpdatedAt(LocalDateTime.now());
        return propertyRepository.save(property);
    }

    @Override
    public void createPost(CreatePostRequest request) {
        Property property = new Property();
        property.setCreatedAt(LocalDateTime.now());
        property.setUpdatedAt(LocalDateTime.now());
        property.setStatus(0L);
        property.setBedroomCount(request.getBedrooms());
        property.setPrice(request.getPrice());
        property.setTitle(request.getTitle());
        property.setDescription(request.getDescription());
        property.setArea(request.getArea());
        propertyRepository.save(property);

    }

    @Override
    public List<PropertyDTO> getActiveProperties() {
        List<Property> properties = propertyRepository.findAllActiveProperties();

        return properties.stream()
                .map(property -> propertyConverter.toDTO(property))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getSaleProperty() {
        List<Property> properties = propertyRepository.findSalesProperties();
        return properties.stream()
                .map(property -> propertyConverter.toDTO(property))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getRentProperty() {
        List<Property> properties = propertyRepository.findRentProperties();
        return properties.stream()
                .map(property -> propertyConverter.toDTO(property))
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> searchProperties(String city, PropertyType propertyType, Double minPrice, Double maxPrice, Double minArea, Double maxArea, PropertyDirection direction, Long bedroomCount) {
        return propertyRepository.searchProperties(city, propertyType, minPrice, maxPrice, minArea, maxArea,direction,bedroomCount);
    }


    @Override
    public Property saveProperty(Property property, List<MultipartFile> imageFiles) throws IOException {
        log.info("Saving property with {} images", imageFiles.size());
        List<PropertyImage> images = new ArrayList<>();

        property.setStatus(0L); // or whatever status you want
        property.setCreatedAt(LocalDateTime.now());
        property.setUpdatedAt(LocalDateTime.now());

        if (property.getAddress() == null) {
            PropertyAddress address = new PropertyAddress();
            property.setAddress(address); // Sẽ tự động set quan hệ hai chiều
        }

        PropertyAddress address = property.getAddress();
        address.setCity(address.getCity() != null ? address.getCity() : City.HANOI);
        address.setWard(address.getWard() != null ? address.getWard() : Ward.HANG_BAI);
        address.setDistrict(address.getDistrict() != null ? address.getDistrict() : District.HOAN_KIEM);

        property = propertyRepository.save(property);

        if (imageFiles != null && !imageFiles.isEmpty()) {
            for (MultipartFile file : imageFiles) {
                if (!file.isEmpty()) {
                    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    Path path = Paths.get(uploadDir + fileName);
                    Files.write(path, file.getBytes());

                    PropertyImage image = new PropertyImage();
                    image.setProperty(property);
                    image.setUrl(path.toString());
                    images.add(image);
                }
            }
        }

        property.setImages(images);
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getLatesProperties(int limit) {
        try {
            return propertyRepository.findByStatusOrderByCreatedAtDesc(
                    1L,  // Đảm bảo là Long type
                    PageRequest.of(0, limit)
            );
        } catch (Exception e) {
            log.error("Error getting latest properties: ", e);
            return new ArrayList<>();
        }

    }
    public String getTimeAgo(LocalDateTime createdDate) {
        if (createdDate == null) return "";

        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(createdDate, now);

        if (duration.toDays() > 0) {
            return duration.toDays() + " ngày trước";
        } else if (duration.toHours() > 0) {
            return duration.toHours() + " giờ trước";
        } else if (duration.toMinutes() > 0) {
            return duration.toMinutes() + " phút trước";
        } else {
            return "Vừa đăng";
        }
    }


}
