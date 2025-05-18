package com.serasa.sistema_c.application.services;

import com.serasa.sistema_c.api.dtos.EventoCpfDTO;
import com.serasa.sistema_c.domain.entities.ConsultaBureauEntity;
import com.serasa.sistema_c.domain.entities.EventoCpfEntity;
import com.serasa.sistema_c.domain.repositories.CompraCartaoRepository;
import com.serasa.sistema_c.domain.repositories.ConsultaBureauRepository;
import com.serasa.sistema_c.domain.repositories.EventoCpfRepository;
import com.serasa.sistema_c.domain.repositories.MovimentacaoFinanceiraRepository;
import com.serasa.sistema_c.utils.EventoCpfMapperUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author maria
 * @date 18/05/2025
 * @description Service único para retornar os eventos financeiros relacionados a um CPF.
 */
@Service
public class EventoCpfServiceImpl implements EventoCpfService {

    private final EventoCpfRepository eventoCpfRepository;

    public EventoCpfServiceImpl(EventoCpfRepository eventoCpfRepository, ConsultaBureauRepository consultaBureauRepository, MovimentacaoFinanceiraRepository movimentacaoFinanceiraRepository, CompraCartaoRepository compraCartaoRepository) {
        this.eventoCpfRepository = eventoCpfRepository;
    }

    @Override
    public EventoCpfDTO consultarCpf(String cpf, String consultadoPor) {
        EventoCpfEntity entity = eventoCpfRepository.findByCpf(cpf);

        if (entity == null) {
            throw new IllegalArgumentException("Nenhum dado encontrado para o CPF informado: " + cpf);
        }

        // para fins de teste, seta quem pesquisou por ultimo, quem pesquisou o bureau. O correto seria a estrutura
        // armazenar isso e atualizar essa informação após retornar o payload, para retornar sempre o último e não o atual.
        ConsultaBureauEntity novaConsulta = new ConsultaBureauEntity();
        novaConsulta.setData(LocalDateTime.now());
        novaConsulta.setConsultadoPor(consultadoPor);
        entity.setUltimaConsultaBureau(novaConsulta);

        return EventoCpfMapperUtil.toDTO(entity);
    }
}