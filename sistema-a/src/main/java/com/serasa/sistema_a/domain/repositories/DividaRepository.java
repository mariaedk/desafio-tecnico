package com.serasa.sistema_a.domain.repositories;

import com.serasa.sistema_a.domain.entities.DividaEntity;

import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Disponibiliza dados da dívida
 */
public interface DividaRepository {

    /**
     * Gera uma lista de dívida mock para a aplicação de exemplo.
     */
    List<DividaEntity> gerarDividas();

    void preLoad();

}
