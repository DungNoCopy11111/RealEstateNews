package com.example.realestate.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "property_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description")
    private String description;

    @Column(name = "icon_url")
    private String iconUrl;

}
