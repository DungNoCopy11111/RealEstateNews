package com.example.realestate.controller;

import com.example.realestate.dtos.request.SignInRequest;
import com.example.realestate.model.User;
import com.example.realestate.repository.UserRepository;
import com.example.realestate.service.AuthenticationService;
import com.example.realestate.service.JwtService;
import com.example.realestate.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("auth")
@Validated
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
//    @PostMapping("/access")
//    public ResponseEntity<TokenResponse> login(@RequestBody SignInRequest request) {
//        return new ResponseEntity<>(authenticationService.authenticate(request), HttpStatus.OK);
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated SignInRequest signInRequest, HttpServletRequest request) {
        try {
            String token = authenticationService.authenticate(signInRequest).getAccessToken();
            request.getSession().setAttribute("token", token);
            log.info("Token received: " + token);
            Authentication authentication = authenticationService.getAuthentication(token);
            if (authentication != null) {
                log.info("Authentication found: " + authentication.getName() + ", isAuthenticated: " + authentication.isAuthenticated());
            } else {
                log.info("Authentication is null.");
            }
            if (authentication != null && authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);

                boolean isAdmin = authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
                if (isAdmin) {
                    return "redirect:/admin";
                } else {
                    return "redirect:/home";
                }
            } else {
                return "redirect:/login?error=true"; // Nếu không xác thực thành công
            }
        } catch (Exception e) {
            log.error("Login failed", e);
            return "redirect:/login?error=true";
        }
    }


}
