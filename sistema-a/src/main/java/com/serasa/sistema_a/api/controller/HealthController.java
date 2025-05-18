package com.serasa.sistema_a.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maria
 * @date 18/05/2025
 * @description Controller que indica se a API está on.
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping()
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }
}
