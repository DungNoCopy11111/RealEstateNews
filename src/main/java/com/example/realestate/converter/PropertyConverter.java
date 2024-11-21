package com.example.realestate.converter;

import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.model.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public static PropertyDTO toDTO(Property property) {
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
                .build();
    }
}
