package com.serasa.sistema_a.application.mapper;

import com.serasa.sistema_a.api.dtos.PessoaDTO;
import com.serasa.sistema_a.domain.entities.PessoaEntity;
import org.mapstruct.Mapper;

/**
 * @author maria
 * @date 16/05/2025
 * @description Mapper responsável por converter {@link PessoaEntity} para {@link PessoaDTO}.
 */
@Mapper(componentModel = "spring", uses = {EnderecoMapper.class, DividaMapper.class})
public interface PessoaMapper {

    PessoaDTO toDTO(PessoaEntity entity);

}
