package com.serasa.sistema_b.application.serviceImpl;

import com.serasa.sistema_b.api.dtos.PessoaScoreDTO;
import com.serasa.sistema_b.application.mapper.PessoaScoreMapper;
import com.serasa.sistema_b.application.services.PessoaScoreService;
import com.serasa.sistema_b.domain.entities.PessoaScoreEntity;
import com.serasa.sistema_b.domain.exceptions.ValidationFactory;
import com.serasa.sistema_b.domain.repositories.PessoaScoreRepository;
import com.serasa.sistema_b.utils.MessageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author maria
 * @date 17/05/2025
 * @description Implementação de {@link PessoaScoreService}
 */
@Service
public class PessoaScoreServiceImpl implements PessoaScoreService {

    private final PessoaScoreRepository pessoaScoreRepository;
    private final PessoaScoreMapper pessoaScoreMapper;

    public PessoaScoreServiceImpl(PessoaScoreRepository pessoaScoreRepository, PessoaScoreMapper pessoaScoreMapper) {
        this.pessoaScoreRepository = pessoaScoreRepository;
        this.pessoaScoreMapper = pessoaScoreMapper;
    }

    public PessoaScoreDTO buscarPorCpf(String cpf) {
        ValidationFactory factory = new ValidationFactory();

        if (cpf == null || cpf.length() != 11) {
            factory.adicionarErro("cpf", MessageUtils.get("validacao.cpf.invalido", 11));
        }

        pessoaScoreRepository.preLoad();
        PessoaScoreEntity pessoa = pessoaScoreRepository.buscarPorCpf(cpf);

        if (pessoa == null) {
            factory.adicionarErro("cpf", MessageUtils.get("validacao.pessoa.nao_encontrada", cpf));
        }

        factory.validar();

        return pessoaScoreMapper.toDTO(pessoa);
    }

    private List<PessoaScoreDTO> listarTodos() {
        return pessoaScoreRepository.listarTodos()
                .stream()
                .map(pessoaScoreMapper::toDTO)
                .collect(Collectors.toList());
    }
}
