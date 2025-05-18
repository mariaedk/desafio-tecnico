package com.serasa.sistema_b.infrastructure.repositories;

import com.serasa.sistema_b.domain.entities.EnderecoEntity;
import com.serasa.sistema_b.domain.repositories.EnderecoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author maria
 * @date 16/05/2025
 * @description Implementação de {@link EnderecoRepository}
 */
@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    @Override
    public EnderecoEntity getEndereco() {
        return gerarEndereco("Rua XV de novembro", "256", "Centro", "Blumenau", "SC", "89000-000");
    }

    @Override
    public EnderecoEntity gerarEndereco(String logradouro, String numero, String bairro, String cidade, String uf, String cep) {
        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setId(1L);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setUf(uf);
        endereco.setCep(cep);
        return endereco;
    }
}
