package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stere
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, StoredUser> usersByEmail = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    /**
     * Used directly in tests
     */
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

    /**
     * Internal holder
     */
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
