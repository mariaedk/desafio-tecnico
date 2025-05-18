package com.serasa.api.infrastructure.clients;

import com.serasa.api.api.dtos.sistema.a.SistemaAPessoaDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author maria
 * @date 18/05/2025
 * @description cliente HTTP para consumir dados do Sistema A.
 */
@Component
public class SistemaAClient {

    private final WebClient webClient;

    public SistemaAClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Mono<SistemaAPessoaDTO> consultar(String cpf, String username, String senha) {
        return autenticar(username, senha)
                .flatMap(token -> webClient.get()
                        .uri("/pessoa/{cpf}", cpf)
                        .header("Authorization", "Bearer " + token)
                        .retrieve()
                        .bodyToMono(SistemaAPessoaDTO.class));
    }

    private Mono<String> autenticar(String username, String senha) {
        Map<String, String> body = Map.of(
                "username", username,
                "password", senha
        );

        return webClient.post()
                .uri("/auth/login")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .flatMap(map -> {
                    Object tokenObj = map.get("accessToken");
                    if (tokenObj == null) {
                        return Mono.error(new RuntimeException("Token JWT não foi retornado pelo Sistema B"));
                    }
                    return Mono.just(tokenObj.toString());
                });
    }

    public Mono<Boolean> health() {
        return webClient.get()
                .uri("/health")
                .exchangeToMono(response -> {
                    boolean success = response.statusCode().is2xxSuccessful();
                    if (!success) {
                        System.err.println("Health check failed: " + response.statusCode());
                    }
                    return Mono.just(success);
                })
                .onErrorResume(e -> {
                    System.err.println("Erro ao chamar /health: " + e.getMessage());
                    return Mono.just(false);
                });
    }
}