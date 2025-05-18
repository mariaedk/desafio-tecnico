package com.serasa.api.api.controller;

import com.serasa.api.application.services.IntegracaoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maria
 * @date 18/05/2025
 * @description Controlador de integração que disponibiliza informações dos sistemas a, b e c.
 */
@RestController
@RequestMapping("/integracao")
@SecurityRequirement(name = "bearerAuth")
public class IntegracaoController {

    private final IntegracaoService integracaoService;

    public IntegracaoController(IntegracaoService integracaoService) {
        this.integracaoService = integracaoService;
    }

    @GetMapping("/sistema-a/{cpf}")
    public ResponseEntity<?> consultarSistemaA(@PathVariable String cpf) {
        return ResponseEntity.ok(integracaoService.consultarSistemaA(cpf));
    }

    @GetMapping("/sistema-b/{cpf}")
    public ResponseEntity<?> consultarSistemaB(@PathVariable String cpf) {
        return ResponseEntity.ok(integracaoService.consultarSistemaB(cpf));
    }

    @GetMapping("/sistema-c/{cpf}")
    public ResponseEntity<?> consultarSistemaC(@PathVariable String cpf) {
        return ResponseEntity.ok(integracaoService.consultarSistemaC(cpf));
    }
}
