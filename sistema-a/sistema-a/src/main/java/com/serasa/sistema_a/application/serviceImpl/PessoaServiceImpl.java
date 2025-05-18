package com.serasa.sistema_a.application.serviceImpl;

import com.serasa.sistema_a.api.dtos.PessoaDTO;
import com.serasa.sistema_a.application.mapper.PessoaMapper;
import com.serasa.sistema_a.application.services.PessoaService;
import com.serasa.sistema_a.domain.entities.PessoaEntity;
import com.serasa.sistema_a.domain.exceptions.ValidationFactory;
import com.serasa.sistema_a.domain.repositories.PessoaRepository;
import com.serasa.sistema_a.utils.CriptoUtils;
import com.serasa.sistema_a.utils.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @author maria
 * @date 16/05/2025
 * @description Implementação de {@link PessoaService}
 */
@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public PessoaDTO buscarPorCpf(String cpf) {
        ValidationFactory factory = new ValidationFactory();

        if (cpf == null || cpf.length() != 11) {
            factory.adicionarErro("cpf", MessageUtils.get("validacao.cpf.invalido", 11));
        }

        factory.validar();

        String cpfCriptografado = CriptoUtils.criptografar(cpf);

        pessoaRepository.preLoad();
        PessoaEntity pessoa = pessoaRepository.buscarPorCpf(cpfCriptografado);

        if (pessoa == null) {
            factory.adicionarErro("cpf", MessageUtils.get("validacao.pessoa.nao_encontrada", cpf));
        }

        factory.validar();

        PessoaDTO dto = pessoaMapper.toDTO(pessoa);

        // para fins do teste, converter manualmente aqui. porém o ideal seria tratar em uma camada mapper ou na
        // camada de apresentação
        dto.setCpf(cpf);

        return dto;
    }
}
