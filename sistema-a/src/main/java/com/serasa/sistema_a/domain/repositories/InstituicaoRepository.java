package com.serasa.sistema_a.domain.repositories;

import com.serasa.sistema_a.domain.entities.InstituicaoEntity;

/**
 * @author maria
 * @date 16/05/2025
 * @description Disponibiliza dados da instituição financeira
 */
public interface InstituicaoRepository {

    /**
     * Busca uma instituição mock para a aplicação de exemplo.
     */
    InstituicaoEntity buscarPorCodigo(Long nome);

    void preLoad();

}
