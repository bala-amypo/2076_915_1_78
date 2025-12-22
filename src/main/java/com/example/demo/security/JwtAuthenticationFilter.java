package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // private final JwtTokenProvider tokenProvider;

    // public JwtAuthenticationFilter(JwtTokenProvider tokenProvider) {
    //     this.tokenProvider = tokenProvider;
    // }

    // @Override
    // protected void doFilterInternal(
    //         @NonNull HttpServletRequest request,
    //         @NonNull HttpServletResponse response,
    //         @NonNull FilterChain filterChain)
    //         throws ServletException, IOException {

    //     String header = request.getHeader("Authorization");

    //     if (header != null && header.startsWith("Bearer ")) {
    //         String token = header.substring(7);

    //         if (tokenProvider.validateToken(token)) {
    //             UsernamePasswordAuthenticationToken authentication =
    //                     new UsernamePasswordAuthenticationToken(
    //                             "user", null, null);

    //             SecurityContextHolder.getContext()
    //                     .setAuthentication(authentication);
    //         }
    //     }

    //     filterChain.doFilter(request, response);
    // }
}

