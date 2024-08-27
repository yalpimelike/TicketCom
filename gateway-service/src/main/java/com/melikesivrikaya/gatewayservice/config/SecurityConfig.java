package com.melikesivrikaya.gatewayservice.config;

import com.melikesivrikaya.gatewayservice.dto.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
@EnableWebSecurity
@EnableWebFluxSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/api/v1/auth/register","/api/v1/auth/login")
                        .permitAll()
                        .pathMatchers("/api/v1/trips/customer/**")
                        .hasRole("ADMIN")
                        .pathMatchers("/api/v1/tickets/customer/**")
                        .hasRole("USER")
                        .pathMatchers("/api/v1/users/customer/**")
                        .hasRole("USER")
                        .pathMatchers("/api/v1/search/**")
                        .hasRole("USER")
                        .anyExchange()
                        .denyAll()
                )
                .addFilterBefore( jwtRequestFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance());
        return http.build();
    }
}
