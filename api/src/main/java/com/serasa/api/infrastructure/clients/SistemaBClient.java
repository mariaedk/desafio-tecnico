package com.serasa.api.infrastructure.clients;

import com.serasa.api.api.dtos.sistema.b.SistemaBPessoaScoreDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author maria
 * @date 18/05/2025
 * @description cliente HTTP para consumir dados do Sistema B.
 */
@Component
public class SistemaBClient {

    private final WebClient webClient;

    public SistemaBClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

    public Mono<SistemaBPessoaScoreDTO> consultar(String cpf, String username, String senha) {
        return autenticar(username, senha)
                .flatMap(token -> webClient.get()
                        .uri("/pessoa/score/{cpf}", cpf)
                        .header("Authorization", "Bearer " + token)
                        .retrieve()
                        .bodyToMono(SistemaBPessoaScoreDTO.class)
                        .onErrorResume(ex -> {
                            return Mono.error(new RuntimeException("Erro ao consultar Sistema B: " + ex.getMessage()));
                        }));
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
