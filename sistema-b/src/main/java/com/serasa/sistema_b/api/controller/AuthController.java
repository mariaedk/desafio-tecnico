package com.serasa.sistema_b.api.controller;

import com.serasa.sistema_b.api.dtos.LoginRequest;
import com.serasa.sistema_b.api.dtos.TokenResponse;
import com.serasa.sistema_b.application.services.UsuarioService;
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
// não precisa do @SecurityRequirement ja que login é publico
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    @Operation(summary = "Realizar login", description = "Autentica o usuário e retorna um token JWT válido")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        String token = usuarioService.autenticar(request.username, request.password);
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
