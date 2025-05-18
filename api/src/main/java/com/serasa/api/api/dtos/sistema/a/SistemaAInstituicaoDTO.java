package com.serasa.api.api.dtos.sistema.a;

/**
 * @author maria
 * @date 18/05/2025
 * @description DTO para representação de instituição financeira.
 * Utilizado na saída da API.
 */
public class SistemaAInstituicaoDTO {

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
