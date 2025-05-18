package com.serasa.sistema_c.domain.enums;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa direcao de uma movimentacao financeira
 */
public enum DirecaoMovimentacao {
    ENVIADO("Valor enviado"),
    RECEBIDO("Valor recebido");

    private final String descricao;

    DirecaoMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
