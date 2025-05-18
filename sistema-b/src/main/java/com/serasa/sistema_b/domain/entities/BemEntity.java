package com.serasa.sistema_b.domain.entities;

import com.serasa.sistema_b.domain.enums.TipoBem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author maria
 * @date 17/05/2025
 * @description Representa Bem que pertence a uma Pessoa.
 */
@Entity
@Table(name = "bem",
        indexes = {
                @Index(name = "idx_tipo_valor", columnList = "ds_tipo, vl_estimado"),
                @Index(name = "idx_pessoa", columnList = "id_pessoa")
        })
public class BemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tp_bem", nullable = false)
    private TipoBem tipo;

    @Column(name = "ds_descricao", length = 100)
    private String descricao;

    @NotNull
    @Column(name = "vl_estimado", nullable = false)
    private BigDecimal valorEstimado;

    public BemEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoBem getTipo() {
        return tipo;
    }

    public void setTipo(TipoBem tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(BigDecimal valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
}
