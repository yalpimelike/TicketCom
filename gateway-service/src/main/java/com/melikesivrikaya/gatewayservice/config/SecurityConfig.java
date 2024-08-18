package com.melikesivrikaya.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // NOT burada izin verdiğim url de sadece get isteğine izin veriyo diğerlerine csrf hatası veriyo
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable) //cssrf hatasını çözüyo
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/api/v1/auth/**")
                        .permitAll() // api/v1 client erişimi için izin ver
                        .anyExchange()
                        .authenticated()
                );

        return http.build();
    }
}
