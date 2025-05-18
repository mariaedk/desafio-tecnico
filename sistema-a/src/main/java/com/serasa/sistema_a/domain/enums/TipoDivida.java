package com.serasa.sistema_a.domain.enums;

public enum TipoDivida {
    CARTAO_CREDITO("Cartão de Crédito"),
    EMPRESTIMO_PESSOAL("Empréstimo Pessoal"),
    FINANCIAMENTO("Financiamento"),
    OUTROS("Outros");

    private final String denominacao;

    TipoDivida(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getDenominacao() {
        return denominacao;
    }
}

