package com.serasa.api.application.services;

import com.serasa.api.api.dtos.sistema.a.SistemaAPessoaDTO;
import com.serasa.api.api.dtos.sistema.b.SistemaBPessoaScoreDTO;
import com.serasa.api.api.dtos.sistema.c.SistemaCEventoCpfDTO;

/**
 * @author maria
 * @date 18/05/2025
 * @description Serviço para centralizar comunicação com outras APIs
 */
public interface IntegracaoService {

    SistemaAPessoaDTO consultarSistemaA(String cpf);
    SistemaBPessoaScoreDTO consultarSistemaB(String cpf);
    SistemaCEventoCpfDTO consultarSistemaC(String cpf);
}