package com.serasa.sistema_c.domain.repositories;

import com.serasa.sistema_c.domain.entities.CompraCartaoEntity;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Repositório de compras com cartão de crédito.
 */
public interface CompraCartaoRepository {

    void preLoad();

    List<CompraCartaoEntity> getData();
}
