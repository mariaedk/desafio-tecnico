package com.serasa.sistema_a.application.services;

import com.serasa.sistema_a.api.dtos.PessoaDTO;

/**
 * @author maria
 * @date 16/05/2025
 * @description Disponibiliza serviços da Pessoa
 */
public interface PessoaService {
    PessoaDTO buscarPorCpf(String cpf);
}
