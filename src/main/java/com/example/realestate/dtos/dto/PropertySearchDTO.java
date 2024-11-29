package com.example.realestate.dtos.dto;

import com.example.realestate.enums.PropertyType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PropertySearchDTO {
    @NotEmpty(message = "Vui lòng chọn tỉnh thành")
    private String city;

    private PropertyType propertyType;

    @Min(value = 0, message = "Giá tối thiểu không được âm")
    private Double minPrice;

    @Min(value = 0, message = "Giá tối đa không được âm")
    private Double maxPrice;

    @Min(value = 0, message = "Diện tích tối thiểu không được âm")
    private Double minArea;

    @Min(value = 0, message = "Diện tích tối đa không được âm")
    private Double maxArea;
}
