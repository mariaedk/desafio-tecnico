package com.serasa.api.domain.exceptions;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa um erro de validação.
 */
public class ValidationError {

    private final String campo;
    private final String mensagem;

    public ValidationError(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
