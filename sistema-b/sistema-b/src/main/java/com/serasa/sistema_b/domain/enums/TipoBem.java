package com.serasa.sistema_b.domain.enums;

/**
 * @author maria
 * @date 17/05/2025
 * @description Enumerado que representa o tipo de um bem.
 */
public enum TipoBem {

    IMOVEL("Imóvel residencial ou comercial"),
    VEICULO("Veículo automotor"),
    MAQUINARIO("Máquinas industriais"),
    INVESTIMENTO("Aplicações financeiras"),
    EQUIPAMENTO("Equipamentos diversos"),
    TERRENO("Terreno ou lote"),
    OUTRO("Outro tipo de bem");

    private final String descricao;

    TipoBem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
