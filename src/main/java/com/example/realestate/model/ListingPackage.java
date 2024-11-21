package com.example.realestate.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "listing_packages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListingPackage extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    @Column(name = "max_images")
    private Integer maxImages;

    @Column(name = "max_refresh_times")
    private Integer maxRefreshTimes;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
