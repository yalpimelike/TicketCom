package com.melikesivrikaya.gatewayservice.config;

import com.melikesivrikaya.gatewayservice.client.AuthClientService;
import com.melikesivrikaya.gatewayservice.dto.UserDetailsDto;
import com.melikesivrikaya.gatewayservice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter implements WebFilter {

    private final AuthClientService authClientService;

    private final JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (exchange.getRequest().getPath().contextPath().equals("/api/v1/auth")){
            return chain.filter(exchange);
        }
        final String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        final String jwtToken;
        final String email;
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }
        jwtToken = authorizationHeader.substring(7);
        email = jwtUtil.extractEmail(jwtToken);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetailsDto userDetailsDto = authClientService.loadUserByUsername(email);
            if (jwtUtil.validateToken(jwtToken, userDetailsDto)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetailsDto, null, userDetailsDto.getAuthorities());
                SecurityContext context = new SecurityContextImpl(authentication);
                return chain.filter(exchange)
                        .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(context)));
            }
        }
        return chain.filter(exchange);
    }
}

