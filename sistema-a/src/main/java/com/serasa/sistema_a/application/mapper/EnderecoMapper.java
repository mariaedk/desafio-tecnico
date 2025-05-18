package com.serasa.sistema_a.application.mapper;

import com.serasa.sistema_a.api.dtos.EnderecoDTO;
import com.serasa.sistema_a.domain.entities.EnderecoEntity;
import org.mapstruct.Mapper;

/**
 * @author maria
 * @date 16/05/2025
 * @description Mapper responsável por converter {@link EnderecoEntity} para {@link EnderecoDTO}.
 */
@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoDTO toDTO(EnderecoEntity entity);

}
