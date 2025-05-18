package com.serasa.api.api.dtos.sistema.b;

import java.math.BigDecimal;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa um Bem no Sistema B
 */
public class SistemaBBemDTO {

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
