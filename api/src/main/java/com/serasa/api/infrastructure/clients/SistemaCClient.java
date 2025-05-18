package com.serasa.api.infrastructure.clients;

import com.serasa.api.api.dtos.sistema.c.SistemaCEventoCpfDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author maria
 * @date 18/05/2025
 * @description cliente HTTP para consumir dados do Sistema C.
 */
@Component
public class SistemaCClient {

    private final WebClient webClient;

    public SistemaCClient() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8083")
                .build();
    }

    public Mono<SistemaCEventoCpfDTO> consultarPorCpf(String cpf, String consultadoPor) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/evento/{cpf}")
                        .queryParam("consultadoPor", consultadoPor)
                        .build(cpf))
                .retrieve()
                .bodyToMono(SistemaCEventoCpfDTO.class);
    }

    public Mono<Boolean> health() {
        return webClient.get()
                .uri("/health")
                .exchangeToMono(response -> Mono.just(response.statusCode().is2xxSuccessful()))
                .onErrorReturn(false);
    }
}
