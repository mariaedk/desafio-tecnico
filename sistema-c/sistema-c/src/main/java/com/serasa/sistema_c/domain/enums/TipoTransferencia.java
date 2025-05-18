package com.serasa.sistema_c.domain.enums;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa tipos de transferencia bancarias
 */
public enum TipoTransferencia {
    PIX("Transferência via PIX"),
    BOLETO("Pagamento por boleto bancário");

    private final String descricao;

    TipoTransferencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
