package com.serasa.sistema_c.infraestructure.repositories;

import com.serasa.sistema_c.domain.entities.CompraCartaoEntity;
import com.serasa.sistema_c.domain.repositories.CompraCartaoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Implementação de {@link CompraCartaoRepository}
 */
@Repository
public class CompraCartaoRepositoryImpl implements CompraCartaoRepository {

    private final List<CompraCartaoEntity> mock = new ArrayList<>();

    @Override
    public void preLoad() {
        CompraCartaoEntity entity = new CompraCartaoEntity();
        entity.setId(1L);
        entity.setData(LocalDateTime.now().minusDays(1));
        entity.setValor(BigDecimal.valueOf(359.90));
        entity.setEstabelecimento("Loja");

        mock.add(entity);
    }

    @Override
    public List<CompraCartaoEntity> getData() {
        return mock;
    }
}
