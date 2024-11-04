package com.example.realestate.service;

import com.example.realestate.dtos.dto.UserDTO;
import com.example.realestate.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  {
    UserDetailsService userDetailsService();
    User getUserById(long id);
    User createUser(UserDTO userDTO);
    User getCurrentUser();
    void updateUser(User user);
    Long countUser();
    List<User> getAllUsers();
    void deleteUser(long id);
}
