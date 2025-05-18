package com.serasa.sistema_c.domain.enums;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa status de um evento
 */
public enum StatusEvento {
    PAGO("Evento já pago"),
    PENDENTE("Pagamento pendente"),
    CANCELADO("Pagamento cancelado");

    private final String descricao;

    StatusEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
