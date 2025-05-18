package com.serasa.sistema_b.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * @author maria
 * @date 17/05/2025
 * @description Representação do usuário para controle de acesso e login na api.
 */
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ds_username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "ds_senha", nullable = false)
    private String senha;

    @NotNull
    @Column(name = "ds_role", nullable = false, unique = true)
    private String role;

    public UsuarioEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
