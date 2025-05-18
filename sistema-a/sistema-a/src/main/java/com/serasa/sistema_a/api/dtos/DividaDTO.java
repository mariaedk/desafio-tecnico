package com.serasa.sistema_a.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author maria
 * @date 16/05/2025
 * @description DTO para representação de uma dívida.
 */
public class DividaDTO extends BaseDTO {

    private String codigoDivida;
    private InstituicaoDTO instituicao;
    private String tipoDivida;
    private BigDecimal valorOriginal;
    private BigDecimal valorAtualizado;
    private LocalDate dataVencimento;
    private String status;
    private Integer atrasoDias;

    public String getCodigoDivida() {
        return codigoDivida;
    }

    public void setCodigoDivida(String codigoDivida) {
        this.codigoDivida = codigoDivida;
    }

    public InstituicaoDTO getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoDTO instituicao) {
        this.instituicao = instituicao;
    }

    public String getTipoDivida() {
        return tipoDivida;
    }

    public void setTipoDivida(String tipoDivida) {
        this.tipoDivida = tipoDivida;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorAtualizado() {
        return valorAtualizado;
    }

    public void setValorAtualizado(BigDecimal valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAtrasoDias() {
        return atrasoDias;
    }

    public void setAtrasoDias(Integer atrasoDias) {
        this.atrasoDias = atrasoDias;
    }
}