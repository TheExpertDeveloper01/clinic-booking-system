package com.P2.CBS.security;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

import com.P2.CBS.service.CustomUserDetailsService;
import com.P2.CBS.util.JwtUtil;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{
        String authorizationHeader = request.getHeader("Authorization");

        // Debugging step to log the incoming Authorization header
        System.out.println("Authorization header: " + authorizationHeader);

        String username = null;
        String jwt = null;



        // Check if the header contains JWT token
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
//          jwt = authorizationHeader.substring(7);
//          try{
//              username = jwtUtil.extractUsername(jwt);
//          }catch (ExpiredJwtException e){
//              // handle expired jwt
//          }
//        }

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            if (authorizationHeader.length() > 7) {
                jwt = authorizationHeader.substring(7);

                // Debugging step to log the extracted token
                System.out.println("Extracted JWT token from header: " + jwt);

                try {
                    username = jwtUtil.extractUsername(jwt);
                    System.out.println("Extracted username from JWT: " + username);
                } catch (ExpiredJwtException e) {
                    System.out.println("JWT token is expired: " + e.getMessage());
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                } catch (JwtException e) {
                    System.out.println("JWT token is invalid: " + e.getMessage());
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            } else {
                System.out.println("Invalid Authorization header format");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
                return;
            }
        } else {
            System.out.println("Authorization header is missing or does not start with Bearer");
        }

        if (username != null && !username.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                System.out.println("Token validation failed for username: " + username);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // If username is not null and the SecurityContexy is empty, authenticate the user
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//            if (jwtUtil.validateToken(jwt, userDetails)){
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }

        filterChain.doFilter(request, response);
    }
}
