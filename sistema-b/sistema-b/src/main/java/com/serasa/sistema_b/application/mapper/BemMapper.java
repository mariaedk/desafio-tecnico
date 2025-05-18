package com.serasa.sistema_b.application.mapper;

import com.serasa.sistema_b.api.dtos.BemDTO;
import com.serasa.sistema_b.domain.entities.BemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author maria
 * @date 18/05/2025
 * @description Mapper responsável por converter {@link BemEntity} para {@link BemDTO}.
 */
@Mapper(componentModel = "spring")
public interface BemMapper {
    @Mapping(target = "tipo", source = "tipo.descricao")
    BemDTO toDTO(BemEntity entity);
    List<BemDTO> toDTOList(List<BemEntity> entities);
}
