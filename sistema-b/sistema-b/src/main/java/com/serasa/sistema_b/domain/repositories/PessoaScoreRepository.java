package com.serasa.sistema_b.domain.repositories;

import com.serasa.sistema_b.domain.entities.PessoaScoreEntity;

import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Interface para acesso a dados de pessoas com score de crédito.
 */
public interface PessoaScoreRepository {
    PessoaScoreEntity buscarPorCpf(String cpf);
    List<PessoaScoreEntity> listarTodos();
    // apenas usado para carregar os dados do mock.
    void preLoad();
}
