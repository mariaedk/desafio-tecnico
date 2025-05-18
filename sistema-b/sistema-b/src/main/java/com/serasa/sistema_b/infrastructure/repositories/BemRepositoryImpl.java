package com.serasa.sistema_b.infrastructure.repositories;

import com.serasa.sistema_b.domain.entities.BemEntity;
import com.serasa.sistema_b.domain.enums.TipoBem;
import com.serasa.sistema_b.domain.repositories.BemRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 17/05/2025
 * @description Implementação de {@link BemRepository}
 */
@Repository
public class BemRepositoryImpl implements BemRepository {

    private final List<BemEntity> mockData = new ArrayList<>();

    public void preLoad() {
        mockData.clear();
        BemEntity b1 = new BemEntity();
        b1.setId(1L);
        b1.setTipo(TipoBem.IMOVEL);
        b1.setDescricao("Casa");
        b1.setValorEstimado(BigDecimal.valueOf(320000));

        BemEntity b2 = new BemEntity();
        b2.setId(2L);
        b2.setTipo(TipoBem.VEICULO);
        b2.setDescricao("Honda Civic");
        b2.setValorEstimado(BigDecimal.valueOf(90000));

        BemEntity b3 = new BemEntity();
        b3.setId(3L);
        b3.setTipo(TipoBem.TERRENO);
        b3.setDescricao("Lote");
        b3.setValorEstimado(BigDecimal.valueOf(150000));

        mockData.add(b1);
        mockData.add(b2);
        mockData.add(b3);
    }

    public List<BemEntity> getData() {
        return mockData;
    }

}
