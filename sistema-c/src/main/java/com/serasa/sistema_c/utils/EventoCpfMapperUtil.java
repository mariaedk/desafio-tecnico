package com.serasa.sistema_c.utils;

import com.serasa.sistema_c.api.dtos.CompraCartaoDTO;
import com.serasa.sistema_c.api.dtos.ConsultaBureauDTO;
import com.serasa.sistema_c.api.dtos.EventoCpfDTO;
import com.serasa.sistema_c.api.dtos.MovimentacaoFinanceiraDTO;
import com.serasa.sistema_c.domain.entities.CompraCartaoEntity;
import com.serasa.sistema_c.domain.entities.ConsultaBureauEntity;
import com.serasa.sistema_c.domain.entities.EventoCpfEntity;
import com.serasa.sistema_c.domain.entities.MovimentacaoFinanceiraEntity;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author maria
 * @date 18/05/2025
 * @description utilitario para mapear entidades para dtos de forma manual.
 */
public class EventoCpfMapperUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static EventoCpfDTO toDTO(EventoCpfEntity entity) {
        EventoCpfDTO dto = new EventoCpfDTO();
        dto.setId(entity.getId());
        dto.setCpf(entity.getCpf());

        dto.setConsultaBureau(toConsultaBureauDTO(entity.getUltimaConsultaBureau()));
        dto.setMovimentacoes(toMovimentacoesDTO(entity.getMovimentacoesRecentes()));
        dto.setUltimaCompraCartao(toCompraCartaoDTO(entity.getUltimaCompraCartao()));

        return dto;
    }

    private static ConsultaBureauDTO toConsultaBureauDTO(ConsultaBureauEntity entity) {
        if (entity == null) return null;

        ConsultaBureauDTO dto = new ConsultaBureauDTO();
        dto.setData(entity.getData().format(FORMATTER));
        dto.setConsultadoPor(entity.getConsultadoPor());
        return dto;
    }

    private static List<MovimentacaoFinanceiraDTO> toMovimentacoesDTO(List<MovimentacaoFinanceiraEntity> list) {
        return list.stream().map(entity -> {
            MovimentacaoFinanceiraDTO dto = new MovimentacaoFinanceiraDTO();
            dto.setData(entity.getData().format(FORMATTER));
            dto.setTipoTransferencia(entity.getTipoTransferencia().name());
            dto.setDirecao(entity.getDirecao().name());
            dto.setValor(entity.getValor());
            dto.setStatusEvento(entity.getStatusEvento().name());
            dto.setDescricao(entity.getDescricao());
            return dto;
        }).collect(Collectors.toList());
    }

    private static CompraCartaoDTO toCompraCartaoDTO(CompraCartaoEntity entity) {
        if (entity == null) return null;

        CompraCartaoDTO dto = new CompraCartaoDTO();
        dto.setId(entity.getId());
        dto.setData(entity.getData().format(FORMATTER));
        dto.setValor(entity.getValor());
        dto.setEstabelecimento(entity.getEstabelecimento());
        return dto;
    }
}