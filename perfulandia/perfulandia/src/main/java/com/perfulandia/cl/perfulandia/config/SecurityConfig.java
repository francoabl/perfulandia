package com.perfulandia.cl.perfulandia.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableConfigurationProperties
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/clientes/**").hasAnyRole("ADMIN", "GERENTE")
                .requestMatchers("/api/productos/**").hasRole("GERENTE")
                .requestMatchers("/api/usuarios/**").hasRole("ADMIN")
                .requestMatchers("/api/sucursales/**").hasRole("GERENTE")
                .requestMatchers("/api/envios/**").hasRole("LOGISTICA")
                .requestMatchers(HttpMethod.POST, "/api/ventas/**").hasRole("VENTAS")
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        return new InMemoryUserDetailsManager(
            User.withUsername("admin").password("{noop}adminpass").roles("ADMIN").build(),
            User.withUsername("gerente").password("{noop}gerentepass").roles("GERENTE").build(),
            User.withUsername("vendedor").password("{noop}ventapass").roles("VENTAS").build(),
            User.withUsername("logistica").password("{noop}logipass").roles("LOGISTICA").build()
        );
    }
}
