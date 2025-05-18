package com.serasa.sistema_a.domain.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Factory para validação de erros.
 */
public class ValidationFactory {

    private final List<ValidationError> erros = new ArrayList<>();

    public void adicionarErro(String campo, String mensagem) {
        erros.add(new ValidationError(campo, mensagem));
    }

    public void validar() {
        if (!erros.isEmpty()) {
            throw new ValidationException(erros);
        }
    }
}
