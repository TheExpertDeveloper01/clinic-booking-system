package com.P2.CBS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;

import com.P2.CBS.util.JwtUtil;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil(@Value("${jwt.secret}") String secretKey) {
        return new JwtUtil(secretKey);
    }
}
