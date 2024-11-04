package com.example.realestate.controller;

import com.example.realestate.model.User;
import com.example.realestate.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/home")
    public String home(){
        return "web/home";
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

}
