package com.serasa.api.api.dtos.sistema.c;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Classe EventoCpfDTO
 */
public class SistemaCEventoCpfDTO {
    public String cpf;
    public SistemaCConsultaBureauDTO consultaBureau;
    public List<SistemaCMovimentacaoFinanceiraDTO> movimentacoes;
    public SistemaCCompraCartaoDTO ultimaCompraCartao;

    public SistemaCEventoCpfDTO() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public SistemaCConsultaBureauDTO getConsultaBureau() {
        return consultaBureau;
    }

    public void setConsultaBureau(SistemaCConsultaBureauDTO consultaBureau) {
        this.consultaBureau = consultaBureau;
    }

    public List<SistemaCMovimentacaoFinanceiraDTO> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<SistemaCMovimentacaoFinanceiraDTO> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public SistemaCCompraCartaoDTO getUltimaCompraCartao() {
        return ultimaCompraCartao;
    }

    public void setUltimaCompraCartao(SistemaCCompraCartaoDTO ultimaCompraCartao) {
        this.ultimaCompraCartao = ultimaCompraCartao;
    }
}