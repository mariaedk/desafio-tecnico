package com.serasa.api.application.services;

import com.serasa.api.api.dtos.LoginRequest;

/**
 * @author maria
 * @date 18/05/2025
 * @description Disponibiliza serviços do usuário
 */
public interface AuthService {

    String autenticar(String username, String senha);

    LoginRequest getCredenciais();

}
