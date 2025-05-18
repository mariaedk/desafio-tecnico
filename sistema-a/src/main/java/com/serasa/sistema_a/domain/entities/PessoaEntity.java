package com.serasa.sistema_a.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Representa uma pessoa.
 */
@Entity
@Table(
    name = "pessoa",
    indexes = {
            @Index(name = "idx_pessoa_cpf", columnList = "nr_cpf")
    }
)
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nr_cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @NotNull
    @Column(name = "ds_nome_pessoa", nullable = false, length = 100)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "id_endereco", nullable = false)
    private EnderecoEntity endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    private List<DividaEntity> dividas;

    public PessoaEntity() {
    }

    @Override
    public String toString() {
        return cpf + " - " + nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<DividaEntity> getDividas() {
        return dividas;
    }

    public void setDividas(List<DividaEntity> dividas) {
        this.dividas = dividas;
    }
}