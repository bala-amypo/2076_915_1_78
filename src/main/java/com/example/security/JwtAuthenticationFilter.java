
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

    private final JwtTokenProvider tokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            if (tokenProvider.validateToken(token)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                "user", null, null);

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}


package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, StoredUser> usersByEmail = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    
    public Map<String, Object> registerUser(
            String name,
            String email,
            String encodedPassword,
            String role) {

        Long userId = idGenerator.getAndIncrement();

        StoredUser stored = new StoredUser(
                userId,
                email,
                encodedPassword,
                role
        );

        usersByEmail.put(email, stored);

        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("email", email);
        result.put("role", role);

        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        StoredUser stored = usersByEmail.get(email);

        if (stored == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(stored.email)
                .password(stored.password)
                .authorities(stored.role)
                .build();
    }
    private static class StoredUser {
        Long id;
        String email;
        String password;
        String role;

        StoredUser(Long id, String email, String password, String role) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.role = role;
        }
    }
}








