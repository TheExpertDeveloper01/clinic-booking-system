package com.P2.CBS.controller;

import com.P2.CBS.model.*;
import com.P2.CBS.repository.RoleRepository;
import com.P2.CBS.service.UserService;
import com.P2.CBS.util.JwtUtil;
import com.P2.CBS.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())

        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        System.out.println("Register endpoint hit."); // Add this for debugging



        // Assign ROLE_PATIENT by default
        Role patientRole = roleRepository.findByName("ROLE_PATIENT");
        if (patientRole == null){
            throw new RuntimeException("Patient role not found. Please create it in the database.");
        }

        // Set the username to the email, or another appropriate value if needed
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            user.setUsername(user.getEmail());
        }

        user.addRole(patientRole);

        userService.registerUser(user);
        System.out.println("User registered successfully."); // Add this for debugging
        return "Registration successful!";
    }

    // Create a separate endpoint for staff registration, or create staff users manually
    @PostMapping("/register-staff")
    public String registerStaff(@RequestBody User user){
        // This endpoint can be secured so that only admins can register staff

        Role staffRole = roleRepository.findByName("ROLE_STAFF");
        if (staffRole == null){
            throw new RuntimeException("Staff role not found. Please create it in the database.");
        }
        user.addRole(staffRole);

        userService.registerUser(user);
        return "Staff registration successful!";
    }

}
