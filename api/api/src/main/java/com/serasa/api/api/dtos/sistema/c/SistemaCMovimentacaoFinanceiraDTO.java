package com.serasa.api.api.dtos.sistema.c;

import java.math.BigDecimal;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa DTO para movimentacao financeira.
 */

public class SistemaCMovimentacaoFinanceiraDTO {
    public String data;
    public String tipoTransferencia;
    public String direcao;
    public BigDecimal valor;
    public String statusEvento;
    public String descricao;

    public SistemaCMovimentacaoFinanceiraDTO() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(String statusEvento) {
        this.statusEvento = statusEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}