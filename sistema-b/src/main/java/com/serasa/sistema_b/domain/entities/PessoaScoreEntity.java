package com.serasa.sistema_b.domain.entities;

import com.serasa.sistema_b.domain.enums.TipoRenda;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Representa uma pessoa.
 */
@Entity
@Table(name = "pessoa_score",
    indexes = {
        @Index(name = "idx_cpf", columnList = "nr_cpf"),
        @Index(name = "idx_renda_score", columnList = "vl_renda, vl_score"),
    })
public class PessoaScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nr_cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @NotNull
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Column(name = "vl_renda", nullable = false)
    private BigDecimal renda;

    @Column(name = "ds_fonte_renda", length = 100)
    private String fonteRenda;

    @Column(name = "tp_renda")
    private TipoRenda tipoRenda;

    @Column(name = "dt_ultimo_emprestimo")
    private LocalDate dataUltimoEmprestimo;

    @NotNull
    @Column(name = "qt_financiamentos", nullable = false)
    private Integer quantidadeFinanciamentos;

    @Column(name = "sn_negativado")
    private Boolean negativado;

    @Column(name = "pc_pontualidade_pagamento")
    private Double percentualPontualidade;

    @NotNull
    @Column(name = "vl_score", nullable = false)
    private Integer score;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    @NotNull
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "pessoa_score", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BemEntity> bens;

    public PessoaScoreEntity() {
    }

    @Override
    public String toString() {
        return cpf ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public TipoRenda getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(TipoRenda tipoRenda) {
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<BemEntity> getBens() {
        return bens;
    }

    public void setBens(List<BemEntity> bens) {
        this.bens = bens;
    }
}