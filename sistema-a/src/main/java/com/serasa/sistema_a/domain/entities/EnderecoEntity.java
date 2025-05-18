package com.serasa.sistema_a.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * @author maria
 * @date 16/05/2025
 * @description Representa endereço no sistema.
 */
@Entity
@Table(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ds_logradouro", nullable = false, length = 150)
    private String logradouro;

    @NotNull
    @Column(name = "nr_endereco", nullable = false, length = 20)
    private String numero;

    @NotNull
    @Column(name = "ds_bairro", nullable = false, length = 70)
    private String bairro;

    @NotNull
    @Column(name = "ds_cidade", nullable = false, length = 100)
    private String cidade;

    @NotNull
    @Column(name = "sg_uf", nullable = false, length = 2)
    private String uf;

    @NotNull
    @Column(name = "nr_cep", nullable = false, length = 8)
    private String cep;

    public EnderecoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero + " - " + bairro + " - " + cidade + "/" + uf + " (" + cep + ")";
    }
}
