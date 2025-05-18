package com.serasa.sistema_a.application.serviceImpl;

import com.serasa.sistema_a.application.services.UsuarioService;
import com.serasa.sistema_a.domain.entities.UsuarioEntity;
import com.serasa.sistema_a.domain.exceptions.ValidationFactory;
import com.serasa.sistema_a.domain.repositories.UsuarioRepository;
import com.serasa.sistema_a.infrastructure.security.JWTUtils;
import com.serasa.sistema_a.utils.MessageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maria
 * @date 17/05/2025
 * @description Implementação de {@link UsuarioService}
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String autenticar(String username, String senha) {
        UsuarioEntity usuario = usuarioRepository.buscarPorUsername(username);
        ValidationFactory factory = new ValidationFactory();
        if (usuario == null) {
            factory.adicionarErro("senha", MessageUtils.get("validacao.usuario.nao_encontrado"));
        }
        factory.validar();
        return JWTUtils.gerarToken(usuario.getUsername(), List.of(usuario.getRole()));
    }
}
