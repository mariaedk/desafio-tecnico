package com.serasa.sistema_a.infrastructure.repositories;

import com.serasa.sistema_a.domain.entities.InstituicaoEntity;
import com.serasa.sistema_a.domain.repositories.InstituicaoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maria
 * @date 16/05/2025
 * @description Implementação de {@link InstituicaoRepository}
 */
@Repository
public class InstituicaoRepositoryImpl implements InstituicaoRepository {

    // para o mock
    private final Map<Long, InstituicaoEntity> instituicoes = new HashMap<>();

    @Override
    public void preLoad() {
        InstituicaoEntity banco = new InstituicaoEntity();
        banco.setId(1L);
        banco.setCodigo(1L);
        banco.setNome("Banco");

        InstituicaoEntity instituicaoFinanceira = new InstituicaoEntity();
        instituicaoFinanceira.setId(2L);
        instituicaoFinanceira.setCodigo(2L);
        instituicaoFinanceira.setNome("Instituição financeira");

        instituicoes.put(banco.getCodigo(), banco);
        instituicoes.put(instituicaoFinanceira.getCodigo(), instituicaoFinanceira);
    }

    @Override
    public InstituicaoEntity buscarPorCodigo(Long codigo) {
        return instituicoes.get(codigo);
    }
}
