package com.serasa.sistema_c.domain.repositories;

import com.serasa.sistema_c.domain.entities.MovimentacaoFinanceiraEntity;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Repositório de movimentações financeiras.
 */
public interface MovimentacaoFinanceiraRepository {

    void preLoad();

    List<MovimentacaoFinanceiraEntity> getData();

}
