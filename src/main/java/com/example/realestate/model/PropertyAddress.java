package com.example.realestate.model;

import com.example.realestate.enums.City;
import com.example.realestate.enums.District;
import com.example.realestate.enums.Ward;
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
    @Column(name = "ward",length = 100)
    private Ward ward;

    @Enumerated(EnumType.STRING)
    @Column(name = "district",length = 100)
    private District district;

    @Enumerated(EnumType.STRING)
    @Column(name = "city",length = 100)
    private City city;

    @OneToOne(mappedBy = "address")
    private Property property;

    @Override
    public String toString() {
        return (ward != null ? ward.getName() : "") + ", " +
                (city != null ? city.getName() : "");
    }

}
