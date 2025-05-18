package com.serasa.api.api.dtos.sistema.a;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description DTO completo de resposta da API do Sistema A.
 */
public class SistemaAPessoaDTO {
    private String cpf;
    private String nome;
    private SistemaAEnderecoDTO endereco;
    private List<SistemaADividaDTO> dividas;

    public SistemaAPessoaDTO() {

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

    public SistemaAEnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(SistemaAEnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public List<SistemaADividaDTO> getDividas() {
        return dividas;
    }

    public void setDividas(List<SistemaADividaDTO> dividas) {
        this.dividas = dividas;
    }
}
