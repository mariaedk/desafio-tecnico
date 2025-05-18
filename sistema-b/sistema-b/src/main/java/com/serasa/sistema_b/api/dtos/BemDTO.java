package com.serasa.sistema_b.api.dtos;

import java.math.BigDecimal;

/**
 * @author maria
 * @date 17/05/2025
 * @description Classe BemDTO
 */
public class BemDTO extends BaseDTO {

    private String tipo;
    private String descricao;
    private BigDecimal valorEstimado;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
