package com.serasa.sistema_c.domain.repositories;

import com.serasa.sistema_c.domain.entities.EventoCpfEntity;

/**
 * @author maria
 * @date 18/05/2025
 * @description Repositório de acesso aos eventos por CPF.
 */
public interface EventoCpfRepository {

    EventoCpfEntity findByCpf(String cpf);

}
