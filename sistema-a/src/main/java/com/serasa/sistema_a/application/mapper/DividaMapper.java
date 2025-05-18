package com.serasa.sistema_a.application.mapper;

import com.serasa.sistema_a.api.dtos.DividaDTO;
import com.serasa.sistema_a.domain.entities.DividaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author maria
 * @date 16/05/2025
 * @description Mapper responsável por converter {@link DividaEntity} para {@link DividaDTO}.
 */
@Mapper(componentModel = "spring", uses = {InstituicaoMapper.class})
public interface DividaMapper {

    @Mapping(target = "tipoDivida", source = "tipoDivida.denominacao")
    @Mapping(target = "status", source = "status.denominacao")
    DividaDTO toDTO(DividaEntity entity);

}
