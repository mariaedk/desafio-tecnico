package com.serasa.sistema_a.domain.repositories;

import com.serasa.sistema_a.domain.entities.PessoaEntity;

/**
 * @author maria
 * @date 16/05/2025
 * @description Disponibiliza dados da pessoa
 */
public interface PessoaRepository {

    /**
     * Gera uma pessoa mock para a aplicação de exemplo.
     */
    PessoaEntity buscarPorCpf(String cpf);

    void preLoad();

}
