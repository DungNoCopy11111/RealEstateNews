package com.example.realestate.service.impl;

import com.example.realestate.converter.PropertyConverter;
import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.model.Property;
import com.example.realestate.repository.PropertyRepository;
import com.example.realestate.service.PropertyService;
import jakarta.el.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream()
                .map(PropertyConverter::toDTO)
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
                .map(PropertyConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Property approveProperty(Long id) throws PropertyNotFoundException {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new PropertyNotFoundException("Property not found with id: " + id));
        property.setStatus(1L);
        property.setUpdatedAt(LocalDateTime.now());
        return propertyRepository.save(property);
    }

}
