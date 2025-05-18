package com.serasa.sistema_b.api.dtos;

/**
 * @author maria
 * @date 17/05/2025
 * @description DTO para representação de endereço.
 * Utilizado na saída da API.
 *
 */
public class EnderecoDTO extends BaseDTO {

    private String numero;
    private String cidade;
    private String uf;
    private String cep;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
}
