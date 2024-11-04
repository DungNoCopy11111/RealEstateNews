package com.example.realestate.controller;

import com.example.realestate.dtos.dto.UserDTO;
import com.example.realestate.model.User;
import com.example.realestate.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping()
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            log.info("accces");
            return ResponseEntity.ok(user);
        } else {
            log.info("accces");
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/register")
    public RedirectView registerUser(
            @Validated @ModelAttribute UserDTO userDTO
    ) {
        try {
            userService.createUser(userDTO);
            return new RedirectView("/login");
        } catch (Exception e) {
            log.error("Create failed", e);
            return new RedirectView("/login?error=true");
        }
    }

    @PostMapping("/edit")
    public RedirectView editUser(@Validated @ModelAttribute User user
    ){
        try {
            userService.updateUser(user);
            log.info("edit");
            return new RedirectView("/admin/users-profile");
        } catch (Exception e) {
            log.error("Update or Edit failed", e);
            return new RedirectView("/login?error=true");
        }
    }

}
