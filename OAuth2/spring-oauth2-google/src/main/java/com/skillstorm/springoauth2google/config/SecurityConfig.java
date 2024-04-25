package com.skillstorm.springoauth2google.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeHttpRequests -> {
                // all requests coming in require authentication
                authorizeHttpRequests.anyRequest().authenticated();
        })
        .csrf(csrf -> csrf.disable());  //disabling csrf ONLY for demo 

        // telling spring security to use our registered OAuth2 Client
        http.oauth2Login(withDefaults());

        return http.build();
    }
    
}
