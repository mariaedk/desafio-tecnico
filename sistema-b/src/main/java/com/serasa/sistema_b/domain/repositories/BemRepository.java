package com.serasa.sistema_b.domain.repositories;

import com.serasa.sistema_b.domain.entities.BemEntity;

import java.util.List;

/**
 * @author maria
 * @date 17/05/2025
 * @description Interface para acesso a dados de bens
 */
public interface BemRepository {

    List<BemEntity> getData();
    // apenas para carregar os dados do mock
    void preLoad();

}
