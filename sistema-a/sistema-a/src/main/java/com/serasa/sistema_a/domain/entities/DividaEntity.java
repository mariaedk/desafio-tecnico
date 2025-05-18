package com.serasa.sistema_a.domain.entities;

import com.serasa.sistema_a.domain.enums.StatusDivida;
import com.serasa.sistema_a.domain.enums.TipoDivida;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author maria
 * @date 16/05/2025
 * @description Representa uma divida no sistema.
 */
@Entity
@Table(name = "divida",
    indexes = {
        @Index(name = "idx_cd_divida", columnList = "cd_divida"),
        @Index(name = "idx_status", columnList = "tp_status"),
        @Index(name = "idx_tipo_divida", columnList = "tp_divida")
    }
)
public class DividaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_divida", nullable = false, length = 20)
    private String codigoDivida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao", nullable = false)
    private InstituicaoEntity instituicao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_divida", nullable = false)
    private TipoDivida tipoDivida;

    @Column(name = "vl_original", nullable = false)
    private BigDecimal valorOriginal;

    @Column(name = "vl_atualizado", nullable = false)
    private BigDecimal valorAtualizado;

    @Column(name = "dt_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_status", nullable = false)
    private StatusDivida status;

    @Column(name = "nr_atraso_dias")
    private Integer atrasoDias;

    public DividaEntity() {

    }

    @Override
    public String toString() {
        return codigoDivida + " - " + instituicao.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoDivida() {
        return codigoDivida;
    }

    public void setCodigoDivida(String codigoDivida) {
        this.codigoDivida = codigoDivida;
    }

    public InstituicaoEntity getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoEntity instituicao) {
        this.instituicao = instituicao;
    }

    public TipoDivida getTipoDivida() {
        return tipoDivida;
    }

    public void setTipoDivida(TipoDivida tipoDivida) {
        this.tipoDivida = tipoDivida;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal  valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorAtualizado() {
        return valorAtualizado;
    }

    public void setValorAtualizado(BigDecimal valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public StatusDivida getStatus() {
        return status;
    }

    public void setStatus(StatusDivida status) {
        this.status = status;
    }

    public Integer getAtrasoDias() {
        return atrasoDias;
    }

    public void setAtrasoDias(Integer atrasoDias) {
        this.atrasoDias = atrasoDias;
    }
}

