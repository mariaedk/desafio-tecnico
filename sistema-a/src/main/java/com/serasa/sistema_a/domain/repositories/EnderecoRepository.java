package com.serasa.sistema_a.domain.repositories;

import com.serasa.sistema_a.domain.entities.EnderecoEntity;

/**
 * @author maria
 * @date 16/05/2025
 * @description Disponibiliza dados de endereço
 */
public interface EnderecoRepository {

    /**
     * Gera um endereço mock para a aplicação de exemplo.
     */
    EnderecoEntity getEndereco();

    EnderecoEntity gerarEndereco(String logradouro, String numero, String bairro, String cidade, String uf, String cep);
}
