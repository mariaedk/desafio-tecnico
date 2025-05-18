package com.serasa.sistema_b.application.services;

import com.serasa.sistema_b.api.dtos.PessoaScoreDTO;

/**
 * @author maria
 * @date 17/05/2025
 * @description Disponibiliza serviços da pessoa score.
 */
public interface PessoaScoreService {
    PessoaScoreDTO buscarPorCpf(String cpf);
}
