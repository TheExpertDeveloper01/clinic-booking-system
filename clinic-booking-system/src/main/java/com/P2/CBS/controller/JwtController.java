package com.P2.CBS.controller;

import com.P2.CBS.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.P2.CBS.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager; // Authentication Manager

    @Autowired
    private UserDetailsService userDetailsService; // to retrieve UserDetails

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        try {
            // Authenticate the credentials
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            // Return 401 Unauthorized if the credentials are incorrect
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // Load user details from the UserDetailsService
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        // Generate JWT token
        final String jwt = jwtUtil.generateToken(userDetails);

        // Return the token in the response
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


//    @PostMapping("/authenticate")
//    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
//        String username = authRequest.getUsername();
//        // Authentication logic here...
//        return ResponseEntity.ok("Authenticated");
//    }
//
//    @PostMapping("/generateToken")
//    public String generateToken(@RequestBody AuthRequest authRequest) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
//        return jwtUtil.generateToken(userDetails);
//    }

    // Inner AuthRequest class with getters and setters
    public static class AuthRequest {
        private String username;
        private String password;

        // Getter for username
        public String getUsername() {
            return username;
        }

        // Setter for username
        public void setUsername(String username) {
            this.username = username;
        }

        // Getter for password
        public String getPassword() {
            return password;
        }

        // Setter for password
        public void setPassword(String password) {
            this.password = password;
        }
    }
}




//package com.P2.CBS.controller;
//
//import com.P2.CBS.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class JwtController {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @GetMapping("/generateToken")
//    public String generateToken(@RequestParam String username) {
//        // Logic to generate a token for the provided username
//        String token = jwtUtil.generateToken(/* your UserDetails object here */);
//        // Add token to model or return it directly
//        return "Token generated: " + token; // Example response
//    }
//}
