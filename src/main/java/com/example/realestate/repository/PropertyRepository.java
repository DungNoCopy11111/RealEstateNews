package com.example.realestate.repository;

import com.example.realestate.enums.PropertyDirection;
import com.example.realestate.enums.PropertyType;
import com.example.realestate.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findTop10ByOrderByCreatedAtDesc();
    @Query("SELECT p FROM Property p WHERE p.status = 1")
    List<Property> findAllActiveProperties();

    @Query("SELECT p FROM Property p WHERE p.propertyType = 'SALE'")
    List<Property> findSalesProperties();

    @Query("SELECT p FROM Property p WHERE p.propertyType = 'RENT'")
    List<Property> findRentProperties();


    @Query("SELECT p FROM Property p WHERE " +
            "(:city is null or p.city = :city) AND " +
            "(:propertyType is null or p.propertyType = :propertyType) AND " +
            "(:minPrice is null or p.price >= :minPrice) AND " +
            "(:maxPrice is null or p.price <= :maxPrice) AND " +
            "(:minArea is null or p.area >= :minArea) AND " +
            "(:maxArea is null or p.area <= :maxArea) AND " +
            "(:direction is null or p.direction = :direction) AND " +
            "(:bedroomCount is null or p.bedroomCount = :bedroomCount)")
    List<Property> searchProperties(
            @Param("city") String city,
            @Param("propertyType") PropertyType propertyType,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("minArea") Double minArea,
            @Param("maxArea") Double maxArea,
            @Param("direction") PropertyDirection direction,
            @Param("bedroomCount") Long bedroomCount
    );

    List<Property> findByStatusOrderByCreatedAtDesc(Long status, Pageable pageable);

    List<Property> findByUser_Id(Long userId);

}
