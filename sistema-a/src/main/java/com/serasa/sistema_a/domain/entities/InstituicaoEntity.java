package com.serasa.sistema_a.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * @author maria
 * @date 16/05/2025
 * @description Representa uma instituição financeira.
 */
@Entity
@Table(name = "instituicao")
public class InstituicaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "cd_instituicao", nullable = false, unique = true)
    private Long codigo;

    @NotNull
    @Column(name = "ds_nome", nullable = false, unique = true, length = 200)
    private String nome;

    public InstituicaoEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
