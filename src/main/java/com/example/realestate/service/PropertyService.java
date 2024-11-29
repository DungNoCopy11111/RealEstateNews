package com.example.realestate.service;

import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.dtos.request.CreatePostRequest;
import com.example.realestate.enums.PropertyType;
import com.example.realestate.model.Property;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PropertyService {
    List<PropertyDTO> getAllProperties();
    Property getPropertyById(Long id);
    List<PropertyDTO> getRecentProperties();
    Property approveProperty(Long id);
    void createPost(CreatePostRequest request);
    List<PropertyDTO> getActiveProperties();
    List<PropertyDTO> getSaleProperty();
    List<PropertyDTO> getRentProperty();
    List<Property> searchProperties(String city, PropertyType propertyType, Double minPrice, Double maxPrice, Double minArea, Double maxArea);
    Property saveProperty(Property property, List<MultipartFile> imageFiles) throws IOException;
    List<Property> getLatesProperties(int limit);
}
