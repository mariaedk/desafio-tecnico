package com.serasa.sistema_c.api.dtos;

/**
 * @author maria
 * @date 17/05/2025
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
