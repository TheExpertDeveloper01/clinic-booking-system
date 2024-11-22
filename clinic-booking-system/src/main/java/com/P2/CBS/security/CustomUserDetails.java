package com.P2.CBS.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.P2.CBS.util.JwtUtil;

import java.util.Collection;
import java.util.stream.Collectors;

// Custom UserDetails implementation
public class CustomUserDetails implements UserDetails {
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Constructor
    public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    // Implement required methods from UserDetails interface
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement your logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your logic
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic
    }
}
