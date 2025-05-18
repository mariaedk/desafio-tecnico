package com.serasa.sistema_c.domain.repositories;

import com.serasa.sistema_c.domain.entities.ConsultaBureauEntity;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Disponibiliza dados de consultas em bureau
 */
public interface ConsultaBureauRepository {

    void preLoad();

    List<ConsultaBureauEntity> getData();
}
