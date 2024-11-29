package com.example.realestate.dtos.response;

import com.example.realestate.enums.PostType;
import com.example.realestate.enums.PropertyType;
import com.example.realestate.model.Property;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private PostType type;
    private PropertyType propertyType;
    private String fullAddress;
    private String title;
    private String description;
    private BigDecimal price;;
    private Double area;
    private List<String> imageUrls;
    private LocalDateTime createdAt;

    public static PostResponse fromEntity(Property post) {
        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setPropertyType(post.getPropertyType());
        response.setFullAddress(String.format("%s, %s, %s, %s",
                post.getAddress().getStreetName(), post.getAddress().getDistrict().getName(),
                post.getAddress().getWard().getName(), post.getAddress().getCity().getName()));
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setPrice(post.getPrice());
        response.setArea(post.getArea());
        response.setCreatedAt(post.getCreatedAt());
//        response.setImageUrls(post.getImages().stream()
//                .map(PostImage::getFileUrl)
//                .collect(Collectors.toList()));
        return response;
    }
}
