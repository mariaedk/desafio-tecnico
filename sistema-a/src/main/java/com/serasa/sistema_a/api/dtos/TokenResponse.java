package com.serasa.sistema_a.api.dtos;

/**
 * @author maria
 * @date 17/05/2025
 * @description Retorna o token caso autenticação bem sucedida
 */
public class TokenResponse {
    public String accessToken;

    public TokenResponse(String token) {
        this.accessToken = token;
    }
}
