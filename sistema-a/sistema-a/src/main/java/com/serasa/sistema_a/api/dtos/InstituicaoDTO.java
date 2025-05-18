package com.serasa.sistema_a.api.dtos;

/**
 * @author maria
 * @date 16/05/2025
 * @description DTO para representação de instituição financeira.
 *  * Utilizado na saída da API.
 */
public class InstituicaoDTO extends BaseDTO {

    private Long codigo;
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
