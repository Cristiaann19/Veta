package com.example.vet.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilitamos CSRF porque para APIs REST con Postman/Angular no es necesario en esta etapa
                .csrf(csrf -> csrf.disable())

                // Autorizamos que CUALQUIER petición (GET, POST, etc.) sea permitida sin login
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // Deshabilitamos el formulario de login por defecto de Spring
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}