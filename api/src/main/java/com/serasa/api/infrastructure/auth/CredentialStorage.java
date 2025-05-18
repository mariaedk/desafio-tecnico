package com.serasa.api.infrastructure.auth;

import org.springframework.stereotype.Component;

/**
 * @author maria
 * @date 18/05/2025
 * @description Classe CredentialStorage
 */
@Component
public class CredentialStorage {

    private String username;
    private String password;

    public void salvar(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean possuiCredenciais() {
        return username != null && password != null;
    }

    public void limpar() {
        this.username = null;
        this.password = null;
    }
}