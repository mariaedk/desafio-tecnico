package com.serasa.sistema_c.infraestructure.repositories;

import com.serasa.sistema_c.domain.entities.EventoCpfEntity;
import com.serasa.sistema_c.domain.repositories.CompraCartaoRepository;
import com.serasa.sistema_c.domain.repositories.ConsultaBureauRepository;
import com.serasa.sistema_c.domain.repositories.EventoCpfRepository;
import com.serasa.sistema_c.domain.repositories.MovimentacaoFinanceiraRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maria
 * @date 18/05/2025
 * @description Implementação de {@link EventoCpfRepository}
 */
@Repository
public class EventoCpfRepositoryImpl implements EventoCpfRepository {

    private static final Map<String, EventoCpfEntity> MOCK_DATA = new HashMap<>();

    private final ConsultaBureauRepository consultaBureauRepository;
    private final CompraCartaoRepository compraCartaoRepository;
    private final MovimentacaoFinanceiraRepository movimentacaoFinanceiraRepository;

    public EventoCpfRepositoryImpl(ConsultaBureauRepository consultaBureauRepository, CompraCartaoRepository compraCartaoRepository, MovimentacaoFinanceiraRepository movimentacaoFinanceiraRepository) {
        this.consultaBureauRepository = consultaBureauRepository;
        this.compraCartaoRepository = compraCartaoRepository;
        this.movimentacaoFinanceiraRepository = movimentacaoFinanceiraRepository;
        preload();
    }

    private void preload() {
        EventoCpfEntity evento = new EventoCpfEntity();
        evento.setId(1L);
        evento.setCpf("12345678901");
        consultaBureauRepository.preLoad();
        evento.setUltimaConsultaBureau(consultaBureauRepository.getData().getFirst());

        compraCartaoRepository.preLoad();
        evento.setUltimaCompraCartao(compraCartaoRepository.getData().getFirst());

        movimentacaoFinanceiraRepository.preLoad();
        evento.setMovimentacoesRecentes(movimentacaoFinanceiraRepository.getData());

        MOCK_DATA.put(evento.getCpf(), evento);
    }

    @Override
    public EventoCpfEntity findByCpf(String cpf) {
        return MOCK_DATA.get(cpf);
    }
}
