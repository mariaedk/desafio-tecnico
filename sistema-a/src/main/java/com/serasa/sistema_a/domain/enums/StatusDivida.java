package com.serasa.sistema_a.domain.enums;

public enum StatusDivida {
    ABERTO("Aberto"),
    RENEGOCIADA("Renegociada"),
    PAGO("Pago"),
    CANCELADO("Cancelado");

    private final String denominacao;

    StatusDivida(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getDenominacao() {
        return denominacao;
    }
}
