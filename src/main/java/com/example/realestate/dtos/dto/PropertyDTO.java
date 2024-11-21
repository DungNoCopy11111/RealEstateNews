package com.example.realestate.dtos.dto;

import com.example.realestate.emums.PropertyDirection;
import com.example.realestate.emums.PropertyType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Double area;
    private Double width;
    private Double length;
    private Integer bedroomCount;
    private Integer bathroomCount;
    private Integer floorCount;
    private Integer yearBuilt;
    private PropertyDirection direction;
    private String legalDocuments;
    private PropertyType propertyType;
    private Long status;
    private Long categoryId;
    private String userPost;
    private String userEmail;
    private String userPhone;
}
