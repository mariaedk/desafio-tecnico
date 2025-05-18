package com.serasa.sistema_c.infraestructure.repositories;

import com.serasa.sistema_c.domain.entities.ConsultaBureauEntity;
import com.serasa.sistema_c.domain.repositories.ConsultaBureauRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Implementação de {@link ConsultaBureauRepository}
 */

@Repository
public class ConsultaBureauRepositoryImpl implements ConsultaBureauRepository {

    List<ConsultaBureauEntity> mock = new ArrayList<>();

    @Override
    public void preLoad() {
        ConsultaBureauEntity entity = new ConsultaBureauEntity();
        entity.setId(1L);
        entity.setData(LocalDateTime.now().minusDays(3));
        entity.setConsultadoPor("Banco");
        mock.add(entity);
    }

    @Override
    public List<ConsultaBureauEntity> getData() {
        return mock;
    }
}
