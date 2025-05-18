package com.serasa.sistema_c.api.dtos;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Classe EventoCpfDTO
 */
public class EventoCpfDTO extends BaseDTO {
    public String cpf;
    public ConsultaBureauDTO consultaBureau;
    public List<MovimentacaoFinanceiraDTO> movimentacoes;
    public CompraCartaoDTO ultimaCompraCartao;

    public EventoCpfDTO() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ConsultaBureauDTO getConsultaBureau() {
        return consultaBureau;
    }

    public void setConsultaBureau(ConsultaBureauDTO consultaBureau) {
        this.consultaBureau = consultaBureau;
    }

    public List<MovimentacaoFinanceiraDTO> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<MovimentacaoFinanceiraDTO> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public CompraCartaoDTO getUltimaCompraCartao() {
        return ultimaCompraCartao;
    }

    public void setUltimaCompraCartao(CompraCartaoDTO ultimaCompraCartao) {
        this.ultimaCompraCartao = ultimaCompraCartao;
    }
}