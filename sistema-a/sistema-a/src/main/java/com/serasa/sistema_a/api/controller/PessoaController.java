package com.serasa.sistema_a.api.controller;

import com.serasa.sistema_a.api.dtos.PessoaDTO;
import com.serasa.sistema_a.application.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maria
 * @date 16/05/2025
 * @description Controller para consultas referente a pessoa
 */
@RestController
@RequestMapping("/pessoa")
@SecurityRequirement(name = "bearerAuth")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Buscar pessoa por CPF", description = "Retorna dados da pessoa baseados no CPF informado.")
    public ResponseEntity<PessoaDTO> buscarPorCpf(@Parameter(description = "CPF da pessoa a ser consultada", example = "12345678900") @PathVariable String cpf) {
        PessoaDTO dto = pessoaService.buscarPorCpf(cpf);
        return ResponseEntity.ok(dto);
    }
}

