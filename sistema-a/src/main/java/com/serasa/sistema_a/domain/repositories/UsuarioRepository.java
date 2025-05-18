package com.serasa.sistema_a.domain.repositories;

import com.serasa.sistema_a.domain.entities.UsuarioEntity;

/**
 * @author maria
 * @date 17/05/2025
 * @description Disponibiliza dados do usuário
 */
public interface UsuarioRepository {

    UsuarioEntity buscarPorUsername(String username);

}
