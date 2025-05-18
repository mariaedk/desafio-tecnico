package com.serasa.sistema_b.infrastructure.repositories;

import com.serasa.sistema_b.domain.entities.BemEntity;
import com.serasa.sistema_b.domain.entities.EnderecoEntity;
import com.serasa.sistema_b.domain.entities.PessoaScoreEntity;
import com.serasa.sistema_b.domain.enums.TipoRenda;
import com.serasa.sistema_b.domain.repositories.BemRepository;
import com.serasa.sistema_b.domain.repositories.EnderecoRepository;
import com.serasa.sistema_b.domain.repositories.PessoaScoreRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maria
 * @date 16/05/2025
 * @description Implementação de {@link PessoaScoreRepository}
 */
@Repository
public class PessoaScoreRepositoryImpl implements PessoaScoreRepository {

    private final EnderecoRepository enderecoRepository;
    private final BemRepository bemRepository;
    private final List<PessoaScoreEntity> mockData = new ArrayList<>();

    public PessoaScoreRepositoryImpl(EnderecoRepository enderecoRepository, BemRepository bemRepository) {
        this.enderecoRepository = enderecoRepository;
        this.bemRepository = bemRepository;
    }

    public void preLoad() {
        mockData.clear();
        PessoaScoreEntity p1 = new PessoaScoreEntity();
        p1.setId(1L);
        p1.setCpf("12345678901");
        p1.setDataNascimento(LocalDate.of(2002, 12, 23));
        p1.setRenda(BigDecimal.valueOf(3500.00));
        p1.setFonteRenda("Empresa");
        p1.setTipoRenda(TipoRenda.CLT);
        p1.setDataUltimoEmprestimo(LocalDate.of(2024, 6, 10));
        p1.setQuantidadeFinanciamentos(2);
        p1.setNegativado(false);
        p1.setPercentualPontualidade(97.3);
        p1.setScore(750);

        EnderecoEntity endereco = enderecoRepository.getEndereco();
        p1.setEndereco(endereco);

        bemRepository.preLoad();
        List<BemEntity> bens = bemRepository.getData();
        p1.setBens(bens);

        mockData.add(p1);
    }

    @Override
    public PessoaScoreEntity buscarPorCpf(String cpf) {
        return mockData.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PessoaScoreEntity> listarTodos() {
        return mockData;
    }

}
