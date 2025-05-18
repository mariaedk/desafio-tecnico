package com.serasa.sistema_a.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

/**
 * @author maria
 * @date 17/05/2025
 * @description classe utilitária responsável pela geração e validação de tokens
 */
public class JWTUtils {

    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hora
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("chave-secreta-segura-jwt-para-api-serasa-2002".getBytes());

    public static String gerarToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Jws<Claims> validarToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
    }
}
