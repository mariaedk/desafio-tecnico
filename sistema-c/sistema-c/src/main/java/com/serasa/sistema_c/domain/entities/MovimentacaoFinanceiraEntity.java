package com.serasa.sistema_c.domain.entities;

import com.serasa.sistema_c.domain.enums.DirecaoMovimentacao;
import com.serasa.sistema_c.domain.enums.StatusEvento;
import com.serasa.sistema_c.domain.enums.TipoTransferencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa movimentações financeiras dentro do sistema.
 */
@Entity
@Table(name = "movimentacao_financeira", indexes = {
        @Index(name = "idx_tipo_transferencia", columnList = "tp_transferencia"),
        @Index(name = "idx_status_evento", columnList = "tp_status_evento")
})
public class MovimentacaoFinanceiraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_evento", nullable = false)
    @NotNull
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_transferencia", nullable = false, length = 20)
    @NotNull
    private TipoTransferencia tipoTransferencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_direcao", nullable = false, length = 20)
    @NotNull
    private DirecaoMovimentacao direcao;

    @Column(name = "vl_movimentado", nullable = false)
    @NotNull
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_status_evento", nullable = false, length = 20)
    @NotNull
    private StatusEvento statusEvento;

    @Column(name = "ds_evento", length = 200)
    private String descricao;

    public MovimentacaoFinanceiraEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public TipoTransferencia getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(TipoTransferencia tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public DirecaoMovimentacao getDirecao() {
        return direcao;
    }

    public void setDirecao(DirecaoMovimentacao direcao) {
        this.direcao = direcao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusEvento getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(StatusEvento statusEvento) {
        this.statusEvento = statusEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
