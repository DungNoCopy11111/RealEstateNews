package com.example.realestate.controller;

import com.example.realestate.converter.PropertyConverter;
import com.example.realestate.dtos.dto.PropertyDTO;
import com.example.realestate.dtos.dto.PropertySearchDTO;
import com.example.realestate.enums.PropertyDirection;
import com.example.realestate.enums.PropertyType;
import com.example.realestate.model.*;
import com.example.realestate.repository.UserRepository;
import com.example.realestate.service.PropertyService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyConverter propertyConverter;
    @GetMapping("/home")
    public String home( @RequestParam(name = "layout",defaultValue = "web/home") String layout, Model model ){
        model.addAttribute("layout",layout);
        List<Property> latestProperties = propertyService.getLatesProperties(10);
        List<PropertyDTO> properties = propertyService.getActiveProperties();
        model.addAttribute("latestProperties",latestProperties);
        model.addAttribute("searchForm",new PropertySearchDTO());
        model.addAttribute("propertyTypes",PropertyType.values());
        model.addAttribute("properties",propertyService.getActiveProperties());
        return "web/index";
    }
//    @GetMapping("/admin")
//    public String admin(Model model,
//                        @RequestParam(name = "layout",defaultValue = "admin/dashboard/general" ) String layout
//    ){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.debug("Loading dashboard page");
//        log.info("Authentication at admin endpoint: " + authentication);
//        if (authentication == null || !authentication.isAuthenticated()) {
//            // Người dùng chưa đăng nhập, xử lý tình huống này
//            System.out.println("No authenticated user found.");
//            return "redirect:/login";
//        }
//        Optional<User> currentUser  = userRepository.findByUsername(authentication.getName());
//        if (currentUser.isPresent()) {
//            User user = currentUser.get();
//            model.addAttribute("user", user);
//        }
//        model.addAttribute("layout", layout);
//        return "admin/index";
//    }
    @GetMapping("/login")
    public String showLogin(){
        return "login/pages-login";
    }
    @GetMapping("/register")
    public String showRegister(){
        return "login/pages-register";
    }
    @GetMapping("/nha-dat-ban")
    public String showNhaDatBan(Model model){
        model.addAttribute("searchForm", new PropertySearchDTO());
        model.addAttribute("saleproperties",propertyService.getSaleProperty());

        return "web/nhadatban";
    }
    @GetMapping("/nha-dat-thue")
    public String showNhaDatThue(Model model){
        model.addAttribute("searchForm", new PropertySearchDTO());
        model.addAttribute("rentproperties",propertyService.getRentProperty());
        return "web/nhadatthue";
    }

    @GetMapping("/phan-tich")
    public String showPhanTich(){
        return "web/phantich";
    }

    @GetMapping("/quan-ly")
    public String showQuanly(Model model,@ModelAttribute("user") User user){

        if (user != null) {
            model.addAttribute("propertybyuser", propertyService.getPropertyByUserId(user.getId()));
            List<Property> property = propertyService.getPropertyByUserId(user.getId());
            log.info("propertybyuser");
            return "web/quanly";
        }
        return "redirect:/login";
    }

    @GetMapping("/info-property/{id}")
    public String showInfoProperty(Model model,@PathVariable Long id){
        try {
            PropertyDTO propertyDTO = propertyConverter.toDTO(propertyService.getPropertyById(id));
            if(propertyDTO == null){
                return "web/nhadatban";
            }
            model.addAttribute("property",propertyDTO);
            log.info("Showing property");
            return "web/infoproperty";

        } catch (Exception e){
            return "web/nhadatban";

        }
    }
    @GetMapping("/post")
    public String showPost(Model model, HttpSession session){
        Property property = new Property();
        PropertyCategory category = new PropertyCategory();
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login";
        }
        category.setId(1L);
        property.setCategory(category);


        property.setUser(currentUser);
        model.addAttribute("property",property);

        model.addAttribute("properties",propertyService.getAllProperties());
        model.addAttribute("propertyTypes", PropertyType.values());
        model.addAttribute("directions", PropertyDirection.values());
        return "web/post";
    }

    @PostMapping("/post")
    public String submitPost(
            @Valid @ModelAttribute("property") Property property,
            BindingResult result,
            @RequestParam(name = "imageFiles", required = false) MultipartFile[] imageFiles, // Đổi tên và kiểu
            Model model
    ) {
        log.info("Submitting post: {}", property);
        log.info("Submitting post with property: {}", property);
        log.info("Image files received: {}", imageFiles != null ? imageFiles.length : 0);
        if (result.hasErrors()) {
            model.addAttribute("propertyTypes", PropertyType.values());
            model.addAttribute("directions", PropertyDirection.values());
            return "web/post";
        }

        try {
            // Kiểm tra và xử lý images
            if (imageFiles != null && imageFiles.length > 0) {
                List<MultipartFile> validImages = new ArrayList<>();
                for (MultipartFile file : imageFiles) {
                    // Kiểm tra file không rỗng và đúng định dạng
                    if (!file.isEmpty() && file.getContentType() != null ){
                        if (file.getSize() <= 2 * 1024 * 1024) { // 2MB limit
                            validImages.add(file);
                        } else {
                            model.addAttribute("error", "File " + file.getOriginalFilename() + " vượt quá 2MB");
                            return "web/post";
                        }
                    }
                }
                propertyService.saveProperty(property, validImages);
                log.info("Submitting post: {}", property);
            } else {
                propertyService.saveProperty(property, Collections.emptyList());
            }

            return "redirect:/home";
        } catch (Exception e) {
            log.error("Error saving property", e);
            model.addAttribute("error", "Có lỗi xảy ra khi đăng tin: " + e.getMessage());
            model.addAttribute("propertyTypes", PropertyType.values());
            model.addAttribute("directions", PropertyDirection.values());
            log.error("Error saving property", e);
            return "web/post";
        }
    }

}
