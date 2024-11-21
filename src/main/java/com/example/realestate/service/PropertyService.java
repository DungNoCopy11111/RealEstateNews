package com.example.realestate.service;

import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.model.Property;

import java.util.List;

public interface PropertyService {
    List<PropertyDTO> getAllProperties();
    Property getPropertyById(Long id);
    List<PropertyDTO> getRecentProperties();
    Property approveProperty(Long id);
}
