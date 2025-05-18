package com.serasa.sistema_a.api.dtos;

/**
 * @author maria
 * @date 16/05/2025
 * @description DTO base para entidades que possuem identificador.
 */
public class BaseDTO {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
