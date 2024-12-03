package com.example.realestate.controller;

import com.example.realestate.converter.PropertyConverter;
import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.model.Property;
import com.example.realestate.model.User;
import com.example.realestate.repository.TransactionRepository;
import com.example.realestate.repository.UserRepository;
import com.example.realestate.service.PropertyService;
import com.example.realestate.service.TransactionService;
import com.example.realestate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private UserService userService;
    @GetMapping("")
    public String admin(Model model,
                        @RequestParam(name = "layout",defaultValue = "admin/dashboard/general" ) String layout
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("No authenticated user found.");
            return "redirect:/login";
        }
        model.addAttribute("layout", layout);
        Long totalUser = userRepository.count();
        long userCount = userRepository.countByUserType("USER");
        int percentage = 0;
        if(totalUser > 0){
            percentage = (int) (userCount * 100 / totalUser);
        }

        model.addAttribute("properties", propertyService.getRecentProperties());
        model.addAttribute("revenue", transactionService.Revenue());
        BigDecimal reve = transactionService.Revenue();
        model.addAttribute("userCount", userCount);
        model.addAttribute("percentage", percentage);
        return "admin/index";
    }
    @GetMapping("/users-profile")
    public String showUserProfile() {
        return "admin/account/profile";
    }

    @GetMapping("/list-user")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        log.info("Showing user list");
        return "admin/account/list-user";
    }
    @GetMapping("/property-listing")
    public String showPropertyListing(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
//        List<PropertyDTO> property = propertyService.getAllProperties();
        log.info("showing property listing");
        return "admin/property/property-listing";
    }


    @GetMapping("/edit/{id}")
    public String showEditUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("userEd", user);
        return "admin/account/edit-user";
    }


    @PostMapping("/edit/{id}")
    public RedirectView editUserId(@Validated @ModelAttribute("userEd") User user,
                                   @PathVariable Long id
    ){
        try {
            userService.updateUser(user);
            log.info("edit");
            return new RedirectView("/admin/list-user");
        } catch (Exception e) {
            log.error("Update or Edit failed", e);
            return new RedirectView("/login?error=true");
        }
    }

    @PostMapping("/delete/{id}")
    public RedirectView deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new RedirectView("/admin/list-user");
    }

    @DeleteMapping("/property/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        try {
            propertyService.deleteProperty(id);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xóa: " + e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @GetMapping("/property/{id}")
    public ResponseEntity<PropertyDTO> getPropertyDetails(@PathVariable Long id) {
        try {
            log.info("Getting property details for ID: {}", id);

            Property property = propertyService.getPropertyById(id);
            if (property == null) {
                log.warn("Property not found with ID: {}", id);
                return ResponseEntity.notFound().build();
            }

            log.info("Found property: {}", property);

            PropertyDTO propertyDTO = propertyConverter.toDTO(property);
            log.info("Converted to DTO: {}", propertyDTO);

            return ResponseEntity.ok(propertyDTO);

        } catch (Exception e) {
            log.error("Error getting property details for ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<?> approve(@PathVariable Long id) {
        Property property = propertyService.approveProperty(id);
        log.info("Approved property: " + property);
        return ResponseEntity.ok().body("Successfully approved property");
    }

    @GetMapping("/property/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test endpoint working");
    }
}
