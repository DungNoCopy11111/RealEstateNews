package com.example.realestate.model;

import com.example.realestate.emums.City;
import com.example.realestate.emums.District;
import com.example.realestate.emums.Ward;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "property_addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyAddress extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ward", nullable = false)
    private Ward ward;

    @Enumerated(EnumType.STRING)
    @Column(name = "district", nullable = false)
    private District district;

    @Enumerated(EnumType.STRING)
    @Column(name = "city", nullable = false)
    private City city;

}
