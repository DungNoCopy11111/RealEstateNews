package com.example.realestate.controller;

import com.example.realestate.model.User;
import com.example.realestate.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@ControllerAdvice
@SessionAttributes("user")
public class GlobalControllerAdvice {
    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public User getCurrentUser(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Kiểm tra authentication hợp lệ
        if (authentication != null && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getName())) {

            // Thử lấy user từ session trước
            User sessionUser = (User) session.getAttribute("user");
            if (sessionUser != null && sessionUser.getUsername().equals(authentication.getName())) {
                return sessionUser;
            }

            // Nếu không có trong session hoặc username không khớp, lấy từ database
            User user = userRepository.findByUsername(authentication.getName())
                    .orElse(null);

            if (user != null) {
                // Lưu user mới vào session
                session.setAttribute("user", user);
                return user;
            }
        }

        // Nếu không authenticated, xóa user khỏi session
        session.removeAttribute("user");
        return null;
    }
}