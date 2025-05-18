package com.serasa.api.api.dtos;

/**
 * @author maria
 * @date 18/05/2025
 * @description Retorna o token caso autenticação bem sucedida
 */
public class TokenResponse {

    public String accessToken;
    public TokenResponse(String token) {
        this.accessToken = token;
    }
}
