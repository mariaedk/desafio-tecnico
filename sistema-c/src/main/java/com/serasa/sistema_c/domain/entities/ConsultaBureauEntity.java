package com.serasa.sistema_c.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author maria
 * @date 18/05/2025
 * @description Representa objeto de consulta de bureau. Funciona como log das consultas de bureau do cpf.
 */
@Entity
@Table(name = "consulta_bureau")
public class ConsultaBureauEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_consulta", nullable = false)
    private LocalDateTime data;

    @Column(name = "ds_consultado_por", nullable = false, length = 100)
    private String consultadoPor;

    public ConsultaBureauEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getConsultadoPor() {
        return consultadoPor;
    }

    public void setConsultadoPor(String consultadoPor) {
        this.consultadoPor = consultadoPor;
    }
}
