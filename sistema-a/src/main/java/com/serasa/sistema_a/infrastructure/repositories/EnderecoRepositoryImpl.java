package com.serasa.sistema_a.infrastructure.repositories;

import com.serasa.sistema_a.domain.entities.EnderecoEntity;
import com.serasa.sistema_a.domain.repositories.EnderecoRepository;
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
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setUf(uf);
        endereco.setCep(cep);
        return endereco;
    }
}
