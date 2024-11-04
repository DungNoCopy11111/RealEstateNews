package com.example.realestate.controller;

import com.example.realestate.model.User;
import com.example.realestate.repository.UserRepository;
import com.example.realestate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private UserRepository userRepository;

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

}
