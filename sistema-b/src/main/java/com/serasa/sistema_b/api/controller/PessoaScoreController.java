package com.serasa.sistema_b.api.controller;

import com.serasa.sistema_b.api.dtos.PessoaScoreDTO;
import com.serasa.sistema_b.application.services.PessoaScoreService;
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
 * @date 17/05/2025
 * @description Controller para consultas referente a pessoa
 */
@RestController
@RequestMapping("/pessoa/score")
@SecurityRequirement(name = "bearerAuth")
public class PessoaScoreController {

    private final PessoaScoreService pessoaService;

    public PessoaScoreController(PessoaScoreService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Buscar score por CPF", description = "Retorna o score de crédito e dados da pessoa baseados no CPF informado")
    public ResponseEntity<PessoaScoreDTO> buscarPorCpf(@Parameter(description = "CPF da pessoa a ser consultada", example = "12345678900") @PathVariable String cpf) {
        // como o sistema A, realiza busca por CPF, porém o DTO não expoe o cpf
        PessoaScoreDTO dto = pessoaService.buscarPorCpf(cpf);
        return ResponseEntity.ok(dto);
    }
}

