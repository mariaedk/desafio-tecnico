package com.serasa.sistema_c.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa informações de compras em cartao.
 */
@Entity
@Table(name = "ultima_compra_cartao", indexes = {
        @Index(name = "idx_estabelecimento", columnList = "ds_estabelecimento")
})
public class CompraCartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_compra", nullable = false)
    @NotNull
    private LocalDateTime data;

    @Column(name = "vl_compra", nullable = false)
    @NotNull
    private BigDecimal valor;

    @Column(name = "ds_estabelecimento", nullable = false, length = 100)
    @NotNull
    private String estabelecimento;

    public CompraCartaoEntity() {

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}

