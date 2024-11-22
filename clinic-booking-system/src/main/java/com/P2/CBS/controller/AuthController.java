package com.P2.CBS.controller;

import com.P2.CBS.model.User;
import com.P2.CBS.model.AuthenticationRequest;
import com.P2.CBS.model.AuthenticationResponse;
import com.P2.CBS.model.Patient;
import com.P2.CBS.util.JwtUtil;
import com.P2.CBS.service.CustomUserDetailsService;
import com.P2.CBS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PatientService patientService;


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
    public String register(@RequestBody Patient patient){
        patientService.createPatient(patient);
        return "Registration successful!";
    }
}
