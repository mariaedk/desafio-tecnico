package com.serasa.sistema_a.application.mapper;

import com.serasa.sistema_a.api.dtos.InstituicaoDTO;
import com.serasa.sistema_a.domain.entities.InstituicaoEntity;
import org.mapstruct.Mapper;

/**
 * @author maria
 * @date 16/05/2025
 * @description Mapper responsável por converter {@link InstituicaoEntity} para {@link InstituicaoDTO}.
 */
@Mapper(componentModel = "spring")
public interface InstituicaoMapper {

    InstituicaoDTO toDTO(InstituicaoEntity entity);

}
