package com.serasa.sistema_c.infraestructure.repositories;

import com.serasa.sistema_c.domain.entities.MovimentacaoFinanceiraEntity;
import com.serasa.sistema_c.domain.enums.DirecaoMovimentacao;
import com.serasa.sistema_c.domain.enums.StatusEvento;
import com.serasa.sistema_c.domain.enums.TipoTransferencia;
import com.serasa.sistema_c.domain.repositories.MovimentacaoFinanceiraRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Classe MovimentacaoFinanceiraRepositoryImpl
 */
@Repository
public class MovimentacaoFinanceiraRepositoryImpl implements MovimentacaoFinanceiraRepository {

    private final List<MovimentacaoFinanceiraEntity> mock = new ArrayList<>();

    @Override
    public void preLoad() {
        MovimentacaoFinanceiraEntity m1 = new MovimentacaoFinanceiraEntity();
        m1.setId(1L);
        m1.setData(LocalDateTime.now().minusDays(2));
        m1.setTipoTransferencia(TipoTransferencia.PIX);
        m1.setDirecao(DirecaoMovimentacao.ENVIADO);
        m1.setValor(BigDecimal.valueOf(1500));
        m1.setStatusEvento(StatusEvento.PAGO);
        m1.setDescricao("Compra de sapato");

        MovimentacaoFinanceiraEntity m2 = new MovimentacaoFinanceiraEntity();
        m2.setId(2L);
        m2.setData(LocalDateTime.now().minusDays(1));
        m2.setTipoTransferencia(TipoTransferencia.BOLETO);
        m2.setDirecao(DirecaoMovimentacao.ENVIADO);
        m2.setValor(BigDecimal.valueOf(200));
        m2.setStatusEvento(StatusEvento.CANCELADO);
        m2.setDescricao("Boleto cancelado para conta de terceiros");

        mock.add(m1);
        mock.add(m2);
    }

    @Override
    public List<MovimentacaoFinanceiraEntity> getData() {
        return mock;
    }

}
