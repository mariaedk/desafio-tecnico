package com.serasa.sistema_b.domain.repositories;

import com.serasa.sistema_b.domain.entities.UsuarioEntity;

/**
 * @author maria
 * @date 17/05/2025
 * @description Interface para acesso a dados de usuario
 */
public interface UsuarioRepository {

    UsuarioEntity buscarPorUsername(String username);

}
