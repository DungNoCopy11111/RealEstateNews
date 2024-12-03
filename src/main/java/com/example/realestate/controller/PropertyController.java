package com.example.realestate.controller;

import com.example.realestate.dtos.dto.PropertySearchDTO;
import com.example.realestate.enums.PropertyDirection;
import com.example.realestate.enums.PropertyType;
import com.example.realestate.model.Property;
import com.example.realestate.repository.PropertyImageRepository;
import com.example.realestate.service.PropertyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private PropertyImageRepository propertyImageRepository;

    @PostMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approve(@PathVariable Long id) {
        Property property = propertyService.approveProperty(id);
        log.info("Approved property: " + property);
        return ResponseEntity.ok().body("Successfully approved property");
    }

    @PostMapping("/search")
    public String searchProperties(@ModelAttribute("searchForm") PropertySearchDTO searchForm, Model model,
                                   HttpServletRequest request
    ) {
        // In log để debug
        log.debug("Received search form: {}", searchForm);
        log.info("Search with: city={}, type={}", searchForm.getCity(), searchForm.getPropertyType());
        List<Property> properties = propertyService.searchProperties(
                searchForm.getCity(),
                searchForm.getPropertyType(),
                searchForm.getMinPrice(),
                searchForm.getMaxPrice(),
                searchForm.getMinArea(),
                searchForm.getMaxArea(),
                searchForm.getDirection(),
                searchForm.getBedroomCount()
        );
        model.addAttribute("layout", "web/home");
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("propertyTypes", PropertyType.values());

        String referer = request.getHeader("Referer");
        if (properties == null) {
            properties = new ArrayList<>(); // Khởi tạo danh sách rỗng nếu null
        }

        if (referer != null) {
            if (referer.contains("/nha-dat-ban")) {
                log.debug("Returning nha-dat-ban view with {} properties", properties.size());
                model.addAttribute("saleproperties", properties);
                return "web/nhadatban";
            } else if (referer.contains("/nha-dat-thue")) {
                log.debug("Returning nha-dat-thue view with {} properties", properties.size());
                model.addAttribute("rentproperties", properties);  // Đặt tên khác cho nhà đất thuê
                return "web/nhadatthue";
            }
        }
        if (properties.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy bất động sản phù hợp");
        }
        model.addAttribute("properties", properties);
        return "web/index";
    }

    @GetMapping("/property-user/{id}")
    public String editProperty(@PathVariable Long id, Model model) {
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("propertyTypes", PropertyType.values());
        model.addAttribute("property", property);
        model.addAttribute("directions", PropertyDirection.values());
        return "web/edit-property";
    }

    @PostMapping("/update")
    public String updateProperty(@ModelAttribute Property property) {
        propertyService.update(property);
        return "redirect:/quan-ly";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        try {
            propertyImageRepository.deleteAllByPropertyId(id);
            propertyService.deleteProperty(id);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xóa: " + e.getMessage());
        }
    }
}
