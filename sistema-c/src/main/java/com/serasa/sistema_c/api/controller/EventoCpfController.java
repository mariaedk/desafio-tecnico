package com.serasa.sistema_c.api.controller;

import com.serasa.sistema_c.api.dtos.EventoCpfDTO;
import com.serasa.sistema_c.application.services.EventoCpfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author maria
 * @date 18/05/2025
 * @description Controller de consulta pública de eventos relacionados ao CPF.
 */
@RestController
@RequestMapping("/evento")
public class EventoCpfController {

    private final EventoCpfService eventoCpfService;

    public EventoCpfController(EventoCpfService eventoCpfService) {
        this.eventoCpfService = eventoCpfService;
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Consulta dados públicos por CPF", description = "Retorna informações de consulta em bureau, movimentações financeiras e última compra no cartão.")
    public ResponseEntity<EventoCpfDTO> consultarPorCpf(@Parameter(description = "CPF da pessoa a ser consultada", example = "12345678900") @PathVariable String cpf,
            @Parameter(description = "Nome da entidade que está fazendo a consulta", example = "Banco Inter")  @RequestParam String consultadoPor
    ) {
        EventoCpfDTO dto = eventoCpfService.consultarCpf(cpf, consultadoPor);
        return ResponseEntity.ok(dto);
    }
}