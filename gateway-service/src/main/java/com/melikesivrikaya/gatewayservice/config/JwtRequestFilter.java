package com.melikesivrikaya.gatewayservice.config;

import com.melikesivrikaya.gatewayservice.client.user.UserClientService;
import com.melikesivrikaya.gatewayservice.dto.UserDetail;
import com.melikesivrikaya.gatewayservice.model.User;
import com.melikesivrikaya.gatewayservice.model.enums.UserType;
import com.melikesivrikaya.gatewayservice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter implements WebFilter {

    private final UserClientService userClientService;

    private final JwtUtil jwtUtil;

    // TODO role ekleme işlemleri yap

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (exchange.getRequest().getPath().contextPath().equals("/api/v1/auth")){
            return chain.filter(exchange);
        }
        final String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        final String jwtToken;
        final String username;
        final UserType userType;
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }
        jwtToken = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwtToken);
        userType = jwtUtil.extractUserType(jwtToken);

        ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                .header("userType", String.valueOf(userType))
                .build();

        exchange = exchange.mutate().request(modifiedRequest).build();

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetail userDetail = new UserDetail(userClientService.userByUsername(username));
            if (jwtUtil.validateToken(jwtToken, userDetail)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                SecurityContext context = new SecurityContextImpl(authentication);
                return chain.filter(exchange)
                        .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(context)));
            }
        }
        return chain.filter(exchange);
    }
}

