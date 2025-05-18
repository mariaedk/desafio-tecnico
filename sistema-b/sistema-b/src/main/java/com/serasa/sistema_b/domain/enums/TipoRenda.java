package com.serasa.sistema_b.domain.enums;

/**
 * @author maria
 * @date 18/05/2025
 * @description Enumerado que representa o tipo de uma renda.
 */
public enum TipoRenda {

    CLT("CLT"),
    AUTONOMO("AUTONOMO"),
    PESSOA_JURIDICA("PESSOA_JURIDICA");

    private final String descricao;

    TipoRenda(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
