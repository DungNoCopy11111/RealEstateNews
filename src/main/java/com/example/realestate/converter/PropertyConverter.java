package com.example.realestate.converter;

import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.model.Property;
import com.example.realestate.model.PropertyImage;
import com.example.realestate.repository.PropertyImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@RequiredArgsConstructor
public class PropertyConverter {
    private final PropertyImageRepository propertyImageRepository;

    public PropertyDTO toDTO(Property property) {

        List<PropertyImage> images = propertyImageRepository.findByPropertyId(property.getId());

        return PropertyDTO.builder()
                .id(property.getId())
                .title(property.getTitle())
                .description(property.getDescription())
                .price(property.getPrice())
                .area(property.getArea())
                .width(property.getWidth())
                .length(property.getLength())
                .bedroomCount(property.getBedroomCount())
                .bathroomCount(property.getBathroomCount())
                .floorCount(property.getFloorCount())
                .yearBuilt(property.getYearBuilt())
                .direction(property.getDirection())
                .legalDocuments(property.getLegalDocuments())
                .propertyType(property.getPropertyType())
                .status(property.getStatus())
                .categoryId(property.getCategory().getId()) // Lấy ID danh mục
                .userPost(property.getUser().getFullName())
                .userEmail(property.getUser().getEmail())
                .userPhone(property.getUser().getPhoneNumber())
                .address(property.getAddress().getWard().getName() + "," + property.getAddress().getCity().getName())
                .images(images)
                .build();
    }
}
