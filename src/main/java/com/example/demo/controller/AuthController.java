package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(CustomUserDetailsService userService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest req) {
        return userService.registerUser(
                req.getName(),
                req.getEmail(),
                req.getPassword(),
                req.getRole()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(), req.getPassword());

        Map<String, Object> user =
                userService.registerUser(
                        "temp", req.getUsername(), req.getPassword(), "USER");

        String token = jwtTokenProvider.generateToken(
                auth,
                (Long) user.get("userId"),
                (String) user.get("role")
        );

        return new AuthResponse(
                token,
                (Long) user.get("userId"),
                (String) user.get("role")
        );
    }
}
