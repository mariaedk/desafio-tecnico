package com.serasa.api.api.dtos.sistema.b;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description DTO para representação de Score de Pessoa.
 * Utilizado na saída da API.
 */
public class SistemaBPessoaScoreDTO {

    private Integer idade;
    private BigDecimal renda;
    private String fonteRenda;
    private String tipoRenda;
    private LocalDate dataUltimoEmprestimo;
    private Integer quantidadeFinanciamentos;
    private Boolean negativado;
    private Double percentualPontualidade;
    private Integer score;
    private SistemaBEnderecoDTO endereco;
    private List<SistemaBBemDTO> bens;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public String getFonteRenda() {
        return fonteRenda;
    }

    public void setFonteRenda(String fonteRenda) {
        this.fonteRenda = fonteRenda;
    }

    public String getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(String tipoRenda) {
        this.tipoRenda = tipoRenda;
    }

    public LocalDate getDataUltimoEmprestimo() {
        return dataUltimoEmprestimo;
    }

    public void setDataUltimoEmprestimo(LocalDate dataUltimoEmprestimo) {
        this.dataUltimoEmprestimo = dataUltimoEmprestimo;
    }

    public Integer getQuantidadeFinanciamentos() {
        return quantidadeFinanciamentos;
    }

    public void setQuantidadeFinanciamentos(Integer quantidadeFinanciamentos) {
        this.quantidadeFinanciamentos = quantidadeFinanciamentos;
    }

    public Boolean getNegativado() {
        return negativado;
    }

    public void setNegativado(Boolean negativado) {
        this.negativado = negativado;
    }

    public Double getPercentualPontualidade() {
        return percentualPontualidade;
    }

    public void setPercentualPontualidade(Double percentualPontualidade) {
        this.percentualPontualidade = percentualPontualidade;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public SistemaBEnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(SistemaBEnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public List<SistemaBBemDTO> getBens() {
        return bens;
    }

    public void setBens(List<SistemaBBemDTO> bens) {
        this.bens = bens;
    }
}