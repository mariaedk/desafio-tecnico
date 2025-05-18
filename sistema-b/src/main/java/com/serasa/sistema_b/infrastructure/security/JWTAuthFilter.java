package com.serasa.sistema_b.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author maria
 * @date 17/05/2025
 * @description filtro de autenticação JWT aplicado em cada requisição da aplicação
 */
@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // executa automaticamente em toda requisição http

        String uri = request.getRequestURI();
        // porém nao deve validar a rota de login
        if (uri.startsWith("/auth/login") ||
                uri.startsWith("/v3/api-docs") ||
                uri.startsWith("/health") ||
                uri.startsWith("/swagger-ui") ||
                uri.equals("/swagger-ui.html")) {
            filterChain.doFilter(request, response);
            return;
        }

        // ler o cabeçalho
        String header = request.getHeader("Authorization");

        // não permitir autenticação se token não começa com bearer
        if (header == null || !header.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"erro\":\"Token JWT nao informado.\"}");
            return;
        }

        // extrai o token (remove o bearer)
        String token = header.replace("Bearer ", "");

        try {
            Jws<Claims> claimsJws = JWTUtils.validarToken(token);

            String username = claimsJws.getBody().getSubject();

            List<String> roles = claimsJws.getBody().get("roles", List.class);

            // converter roles em objetos de permissao
            List<SimpleGrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // adiciona prefixo "ROLE_"
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);

            // salva usuario no contexto da aplicacao
            SecurityContextHolder.getContext().setAuthentication(authentication);

        // se token for inválido ou der erro, retorna msg de exceção
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("Token inválido ou expirado");
        }

        filterChain.doFilter(request, response);
    }
}
