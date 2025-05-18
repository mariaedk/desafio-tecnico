package com.serasa.api.api.controller;

import com.serasa.api.api.dtos.LoginDTO;
import com.serasa.api.api.dtos.TokenResponse;
import com.serasa.api.application.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maria
 * @date 18/05/2025
 * @description Implementação básica de controller para login
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Operation(summary = "Realizar login", description = "Autentica o usuário e retorna um token JWT válido")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginDTO request) {
        String token = authService.autenticar(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
