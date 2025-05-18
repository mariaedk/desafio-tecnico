package com.serasa.api.api.dtos;

/**
 * @author maria
 * @date 18/05/2025
 * @description Classe para informar o login
 */
public class LoginRequest {
    public String username;
    public String password;
    public String role;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
