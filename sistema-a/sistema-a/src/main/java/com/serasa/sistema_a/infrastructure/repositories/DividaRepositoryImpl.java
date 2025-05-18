package com.serasa.sistema_a.infrastructure.repositories;

import com.serasa.sistema_a.domain.entities.DividaEntity;
import com.serasa.sistema_a.domain.enums.StatusDivida;
import com.serasa.sistema_a.domain.enums.TipoDivida;
import com.serasa.sistema_a.domain.repositories.DividaRepository;
import com.serasa.sistema_a.domain.repositories.InstituicaoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Implementação de {@link DividaRepository}
 */
@Repository
public class DividaRepositoryImpl implements DividaRepository {

    private final List<DividaEntity> mockData = new ArrayList<>();
    private InstituicaoRepository instituicaoRepository;

    public DividaRepositoryImpl(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public void preLoad() {
        instituicaoRepository.preLoad();
        mockData.clear();

        DividaEntity d1 = new DividaEntity();
        d1.setId(1L);
        d1.setCodigoDivida("1");
        d1.setInstituicao(instituicaoRepository.buscarPorCodigo(1L));
        d1.setTipoDivida(TipoDivida.CARTAO_CREDITO);
        d1.setValorOriginal(BigDecimal.valueOf(3200.00));
        d1.setValorAtualizado(BigDecimal.valueOf(3675.90));
        d1.setDataVencimento(LocalDate.of(2023, 2, 15));
        d1.setStatus(StatusDivida.ABERTO);
        d1.setAtrasoDias(84);

        DividaEntity d2 = new DividaEntity();
        d2.setId(2L);
        d2.setCodigoDivida("2");
        d2.setInstituicao(instituicaoRepository.buscarPorCodigo(2L));
        d2.setTipoDivida(TipoDivida.EMPRESTIMO_PESSOAL);
        d2.setValorOriginal(BigDecimal.valueOf(1000.00));
        d2.setValorAtualizado(BigDecimal.valueOf(1085.00));
        d2.setDataVencimento(LocalDate.of(2024, 1, 1));
        d2.setStatus(StatusDivida.RENEGOCIADA);
        d2.setAtrasoDias(0);

        mockData.add(d1);
        mockData.add(d2);
    }

    @Override
    public List<DividaEntity> gerarDividas() {
        return mockData;
    }
}
