package com.serasa.sistema_b.application.mapper;

import com.serasa.sistema_b.api.dtos.EnderecoDTO;
import com.serasa.sistema_b.domain.entities.EnderecoEntity;
import org.mapstruct.Mapper;

/**
 * @author maria
 * @date 18/05/2025
 * @description Mapper responsável por converter {@link EnderecoEntity} para {@link EnderecoDTO}.
 */
@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDTO toDTO(EnderecoEntity entity);
}
