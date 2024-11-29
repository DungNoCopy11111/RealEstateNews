package com.example.realestate.service;

import com.example.realestate.model.PropertyImage;

import java.util.List;

public interface PropertyImageService {
    List<PropertyImage> getImageByPropertyId(Long propertyId);
    byte[] getImageData(Long imageId);
}
