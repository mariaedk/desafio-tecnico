package com.serasa.api.domain.exceptions;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Exceção padrão da API
 */
public class ValidationException extends RuntimeException {
    private final List<ValidationError> erros;

    public ValidationException(List<ValidationError> erros) {
        super("Erro(s) de validação encontrados.");
        this.erros = erros;
    }

    public List<ValidationError> getErros() {
        return erros;
    }
}

