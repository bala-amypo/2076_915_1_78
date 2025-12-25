package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //     http
    //         .csrf(csrf -> csrf.disable())
    //         .authorizeHttpRequests(auth -> auth
    //             // ✅ allow swagger
    //             .requestMatchers(
    //                     "/swagger-ui/**",
    //                     "/v3/api-docs/**",
    //                     "/swagger-ui.html"
    //             ).permitAll()

    //             // allow auth endpoints if you have them
    //             .requestMatchers("/auth/**").permitAll()

    //             // everything else secured
    //             .anyRequest().authenticated()
    //         )
    //         .formLogin(form -> form.disable())
    //         .httpBasic(basic -> basic.disable());

    //     return http.build();
    // }
}
