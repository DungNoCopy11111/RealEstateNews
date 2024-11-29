package com.example.realestate.dtos.request;

import com.example.realestate.enums.PostType;
import com.example.realestate.enums.PropertyType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

// CreatePostRequest.java
@Getter
@Setter
@NoArgsConstructor
public class CreatePostRequest {

    @NotNull(message = "Loại tin rao không được để trống")
    private PostType type;

    @NotNull(message = "Loại bất động sản không được để trống")
    private PropertyType propertyType;

    // Địa chỉ
    @NotBlank(message = "Vui lòng chọn tỉnh/thành phố")
    private String city;

    @NotBlank(message = "Vui lòng chọn quận/huyện")
    private String district;

    @NotBlank(message = "Vui lòng chọn phường/xã")
    private String ward;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String streetAddress;

    // Thông tin bài viết
    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(min = 30, max = 99, message = "Tiêu đề phải từ 30 đến 99 ký tự")
    private String title;

    @NotBlank(message = "Mô tả không được để trống")
    @Size(min = 30, max = 3000, message = "Mô tả phải từ 30 đến 3000 ký tự")
    private String description;

    // Thông tin bất động sản
    @NotNull(message = "Giá không được để trống")
    @Min(value = 0, message = "Giá phải lớn hơn 0")
    private BigDecimal price;

    @NotNull(message = "Diện tích không được để trống")
    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
    private Double area;

    private Integer bedrooms;
    private Integer toilets;
    private Integer floors;

    // Tiện ích
    private boolean hasParking;
    private boolean hasSecurity;
    private boolean hasPool;
    private boolean hasGym;
    private boolean hasElevator;
    private boolean hasGarden;

//    // Hình ảnh
//    private List<MultipartFile> images;
}
