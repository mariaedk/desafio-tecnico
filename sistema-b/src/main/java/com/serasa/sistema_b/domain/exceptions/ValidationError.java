package com.serasa.sistema_b.domain.exceptions;

/**
 * @author maria
 * @date 16/05/2025
 * @description Classe ValidationError
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
