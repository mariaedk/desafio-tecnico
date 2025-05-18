package com.serasa.sistema_b.application.mapper;

import com.serasa.sistema_b.api.dtos.PessoaScoreDTO;
import com.serasa.sistema_b.domain.entities.PessoaScoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author maria
 * @date 17/05/2025
 * @description Mapper responsável por converter {@link PessoaScoreEntity} para {@link PessoaScoreDTO}.
 */
@Mapper(componentModel = "spring", uses = {EnderecoMapper.class, BemMapper.class})
public interface PessoaScoreMapper {
    @Mappings({
        @Mapping(target = "idade", expression = "java(java.time.Period.between(entity.getDataNascimento(), java.time.LocalDate.now()).getYears())"),
        @Mapping(target = "tipoRenda", source = "tipoRenda.descricao")
    })
    PessoaScoreDTO toDTO(PessoaScoreEntity entity);

}