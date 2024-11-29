package com.example.realestate.controller;

import com.example.realestate.dtos.dto.PropertySearchDTO;
import com.example.realestate.enums.PropertyType;
import com.example.realestate.model.Property;
import com.example.realestate.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/property")
@Slf4j
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approve(@PathVariable Long id) {
        Property property = propertyService.approveProperty(id);
        log.info("Approved property: " + property);
        return ResponseEntity.ok().body("Successfully approved property");
    }

    @PostMapping("/search")
    public String searchProperties(@ModelAttribute("searchForm") PropertySearchDTO searchForm, Model model) {
        // In log để debug
        log.info("Search with: city={}, type={}", searchForm.getCity(), searchForm.getPropertyType());
        List<Property> properties = propertyService.searchProperties(
                searchForm.getCity(),
                searchForm.getPropertyType(),
                searchForm.getMinPrice(),
                searchForm.getMaxPrice(),
                searchForm.getMinArea(),
                searchForm.getMaxArea()
        );
        model.addAttribute("layout", "web/home");
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("propertyTypes", PropertyType.values());
        model.addAttribute("properties", properties);
        if (properties == null) {
            properties = new ArrayList<>(); // Khởi tạo danh sách rỗng nếu null
        }
        if (properties.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy bất động sản phù hợp");
        }
        return "web/index";
    }
}
