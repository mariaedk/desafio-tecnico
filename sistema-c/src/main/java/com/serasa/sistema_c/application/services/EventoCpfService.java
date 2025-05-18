package com.serasa.sistema_c.application.services;

import com.serasa.sistema_c.api.dtos.EventoCpfDTO;

/**
 * @author maria
 * @date 18/05/2025
 * @description Disponibiliza consulta para Eventos relacionados ao CPF
 */
public interface EventoCpfService {

    EventoCpfDTO consultarCpf(String cpf, String consultadoPor);
}
