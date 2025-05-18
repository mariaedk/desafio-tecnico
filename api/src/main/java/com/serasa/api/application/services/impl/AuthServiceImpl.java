package com.serasa.api.application.services.impl;

import com.serasa.api.api.dtos.LoginRequest;
import com.serasa.api.application.services.AuthService;
import com.serasa.api.domain.exceptions.ValidationFactory;
import com.serasa.api.infrastructure.security.JWTUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author maria
 * @date 18/05/2025
 * @description Implementação de {@link AuthService}
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final AtomicReference<LoginRequest> credentials = new AtomicReference<>();

    private final List<LoginRequest> usuarios = List.of(
            new LoginRequest("analista", "analista123", "CONSULTA"),
            new LoginRequest("admin", "admin123", "ADMINISTRADOR")
    );

    @Override
    public String autenticar(String username, String password) {
        ValidationFactory factory = new ValidationFactory();

        Optional<LoginRequest> usuario = usuarios.stream()
                .filter(u -> u.username.equals(username) && u.password.equals(password))
                .findFirst();

        if (usuario.isEmpty()) {
            factory.adicionarErro("sistema", "Login inválido");
        }

        factory.validar();

        credentials.set(new LoginRequest(username, password));

        LoginRequest loginRequest = usuario.get();
        return JWTUtils.gerarToken(loginRequest.username, List.of(loginRequest.role));
    }

    public LoginRequest getCredenciais() {
        return credentials.get();
    }
}