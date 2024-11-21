package com.P2.CBS.controller;

import com.P2.CBS.model.User;
import com.P2.CBS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class ProfileController {

    @Autowired
    private UserService userService;

    // GET method to retrieve user profile
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(Authentication authentication){
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    // PUT method to update user profile
    @PutMapping("/profile")
    public ResponseEntity<User> updateUserProfile(@RequestBody User updatedUser, Authentication authentication){
        String username = authentication.getName();
        User savedUser = userService.updateUser(username, updatedUser);
        return ResponseEntity.ok(savedUser);

        // Update user fields
//        user.setFirstName(updatedUser.getFirstName());
//        user.setLastName(updatedUser.getLastName());
//        user.setEmail(updatedUser.getEmail());
//
//        User savedUser = userService.saveUser(user);
//        return ResponseEntity.ok(savedUser);
    }
}
