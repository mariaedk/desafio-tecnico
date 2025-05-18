package com.serasa.sistema_c.api.dtos;

import java.math.BigDecimal;

/**
 * @author maria
 * @date 18/05/2025
 * @description DTO para compras no cartão para expor para API.
 */
public class CompraCartaoDTO extends BaseDTO {
    public String data;
    public BigDecimal valor;
    public String estabelecimento;

    public CompraCartaoDTO() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
