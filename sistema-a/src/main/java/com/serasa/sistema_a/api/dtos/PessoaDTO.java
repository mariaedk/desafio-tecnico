package com.serasa.sistema_a.api.dtos;

import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description DTO para representação de Pessoa.
 *  * Utilizado na saída da API.
 */
public class PessoaDTO extends BaseDTO {

    private String cpf;
    private String nome;
    private EnderecoDTO endereco;
    private List<DividaDTO> dividas;

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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public List<DividaDTO> getDividas() {
        return dividas;
    }

    public void setDividas(List<DividaDTO> dividas) {
        this.dividas = dividas;
    }
}
