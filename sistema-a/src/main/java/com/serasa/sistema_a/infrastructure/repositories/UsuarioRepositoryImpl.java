package com.serasa.sistema_a.infrastructure.repositories;

import com.serasa.sistema_a.domain.entities.UsuarioEntity;
import com.serasa.sistema_a.domain.repositories.UsuarioRepository;
import com.serasa.sistema_a.utils.CriptoUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author maria
 * @date 17/05/2025
 * @description Implementação de {@link UsuarioRepository}
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final List<UsuarioEntity> usuarios = List.of(
            criar("analista", "analista123", "CONSULTA"),
            criar("admin", "admin123", "ADMINISTRADOR")
    );

    private UsuarioEntity criar(String username, String senha, String role) {
        UsuarioEntity user = new UsuarioEntity();
        user.setUsername(username);
        user.setSenha(CriptoUtils.criptografar(senha));
        user.setRole(role);
        return user;
    }

    @Override
    public UsuarioEntity buscarPorUsername(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
