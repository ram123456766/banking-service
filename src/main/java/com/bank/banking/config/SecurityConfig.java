package com.bank.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // 🔴 VERY IMPORTANT FOR POST APIs
                .csrf(csrf -> csrf.disable())

                // 🔓 Allow EVERYTHING for now
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // ❌ Disable default login + basic auth
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.disable());

        return http.build();
    }
}
