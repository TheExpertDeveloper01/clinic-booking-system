package com.P2.CBS.controller;  // Ensure the package is correct

public class AuthRequest {
    private String email;
    private String password;

    // Constructor
    public AuthRequest(String username, String password) {
        this.email = username;
        this.password = password;
    }

    // Getter for username
    public String getEmail() {
        return email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }
}
