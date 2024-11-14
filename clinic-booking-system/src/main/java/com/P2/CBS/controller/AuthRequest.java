package com.P2.CBS.controller;  // Ensure the package is correct

public class AuthRequest {
    private String username;
    private String password;

    // Constructor
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }
}
