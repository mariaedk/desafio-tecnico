package com.serasa.api.application.services.impl;

import com.serasa.api.api.dtos.LoginRequest;
import com.serasa.api.api.dtos.sistema.a.SistemaAPessoaDTO;
import com.serasa.api.api.dtos.sistema.b.SistemaBPessoaScoreDTO;
import com.serasa.api.api.dtos.sistema.c.SistemaCEventoCpfDTO;
import com.serasa.api.application.services.AuthService;
import com.serasa.api.application.services.IntegracaoService;
import com.serasa.api.domain.exceptions.ValidationFactory;
import com.serasa.api.infrastructure.clients.SistemaAClient;
import com.serasa.api.infrastructure.clients.SistemaBClient;
import com.serasa.api.infrastructure.clients.SistemaCClient;
import org.springframework.stereotype.Service;

/**
 * @author maria
 * @date 18/05/2025
 * @description Implementação de {@link IntegracaoService}
 */
@Service
public class IntegracaoServiceImpl implements IntegracaoService {

    private final SistemaAClient sistemaAClient;
    private final SistemaBClient sistemaBClient;
    private final SistemaCClient sistemaCClient;
    private final AuthService authService;

    public IntegracaoServiceImpl(SistemaAClient sistemaAClient, SistemaBClient sistemaBClient, SistemaCClient sistemaCClient, AuthService authService) {
        this.sistemaAClient = sistemaAClient;
        this.sistemaBClient = sistemaBClient;
        this.sistemaCClient = sistemaCClient;
        this.authService = authService;
    }

    @Override
    public SistemaAPessoaDTO consultarSistemaA(String cpf) {
        LoginRequest credenciais = authService.getCredenciais();
        ValidationFactory factory = new ValidationFactory();

        if (Boolean.FALSE.equals(sistemaBClient.health().block())) {
            factory.adicionarErro("sistemaA", "Sistema A está indisponível");
        }

        if (credenciais == null || credenciais.username == null || credenciais.password == null) {
            factory.adicionarErro("sistemaA", "Informe novamente as credenciais.");
        }

        factory.validar();

        // precisaria fazer uma validação para pegar o erro que vem do retorno da api consultada,
        // pois se informar cpf invalido as apis dos sistema até validam, mas aqui não está sendo validado.
        return sistemaAClient.consultar(cpf, credenciais.username, credenciais.password).block();
    }

    @Override
    public SistemaBPessoaScoreDTO consultarSistemaB(String cpf) {
        LoginRequest credenciais = authService.getCredenciais();
        ValidationFactory factory = new ValidationFactory();

        if (Boolean.FALSE.equals(sistemaBClient.health().block())) {
            factory.adicionarErro("sistemaB", "Sistema B está indisponível");
        }

        if (credenciais == null || credenciais.username == null || credenciais.password == null) {
            factory.adicionarErro("sistemaB", "Informe novamente as credenciais.");
        }

        factory.validar();

        return sistemaBClient.consultar(cpf, credenciais.username, credenciais.password).block();
    }

    @Override
    public SistemaCEventoCpfDTO consultarSistemaC(String cpf) {
        LoginRequest credenciais = authService.getCredenciais();
        ValidationFactory factory = new ValidationFactory();

        if (Boolean.FALSE.equals(sistemaCClient.health().block())) {
            factory.adicionarErro("sistema", "Sistema C está indisponível");
        }

        return sistemaCClient.consultarPorCpf(cpf, "API Integradora").block();
    }
}
