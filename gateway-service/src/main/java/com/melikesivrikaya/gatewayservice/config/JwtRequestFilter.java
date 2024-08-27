package com.melikesivrikaya.gatewayservice.config;

import com.melikesivrikaya.gatewayservice.client.user.UserClientService;
import com.melikesivrikaya.gatewayservice.dto.UserDetail;
import com.melikesivrikaya.gatewayservice.exception.ExceptionMessages;
import com.melikesivrikaya.gatewayservice.model.User;
import com.melikesivrikaya.gatewayservice.utils.JwtUtil;
import jakarta.security.auth.message.AuthException;
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
        final String userType;
        final Long userId;
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }
        jwtToken = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwtToken);
        userType = jwtUtil.extractUserType(jwtToken);
        userId = jwtUtil.extractUserId(jwtToken);

        ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                .header("userType", String.valueOf(userType))
                .header("userId", String.valueOf(userId))
                .build();

        exchange = exchange.mutate().request(modifiedRequest).build();

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userClientService.userByUsername(username);
            if (user != null){
                UserDetail userDetail = new UserDetail(user);
                if (jwtUtil.validateToken(jwtToken, userDetail)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                    SecurityContext context = new SecurityContextImpl(authentication);
                    return chain.filter(exchange)
                            .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(context)));
                }
            } else {
                try {
                    throw new AuthException(ExceptionMessages.USER_NOT_FOUNT);
                } catch (AuthException e) {
                    throw new RuntimeException(e);
                }
            }



        }
        return chain.filter(exchange);
    }
}

