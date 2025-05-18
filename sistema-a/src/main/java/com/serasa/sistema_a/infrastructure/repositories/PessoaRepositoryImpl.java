package com.serasa.sistema_a.infrastructure.repositories;

import com.serasa.sistema_a.domain.entities.PessoaEntity;
import com.serasa.sistema_a.domain.repositories.DividaRepository;
import com.serasa.sistema_a.domain.repositories.EnderecoRepository;
import com.serasa.sistema_a.domain.repositories.PessoaRepository;
import com.serasa.sistema_a.utils.CriptoUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Implementação de {@link PessoaRepository}
 */
@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

    private final List<PessoaEntity> mockData = new ArrayList<>();

    private EnderecoRepository enderecoRepository;
    private DividaRepository dividaRepository;

    public PessoaRepositoryImpl(EnderecoRepository enderecoRepository, DividaRepository dividaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.dividaRepository = dividaRepository;
    }

    public void preLoad() {
        dividaRepository.preLoad();
        mockData.clear();
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setId(1L);
        pessoa.setCpf(CriptoUtils.criptografar("12345678911"));
        pessoa.setNome("maria eduarda");
        pessoa.setEndereco(enderecoRepository.getEndereco());
        pessoa.setDividas(dividaRepository.gerarDividas());
        mockData.add(pessoa);
    }

    @Override
    public PessoaEntity buscarPorCpf(String cpf) {
        return mockData.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
