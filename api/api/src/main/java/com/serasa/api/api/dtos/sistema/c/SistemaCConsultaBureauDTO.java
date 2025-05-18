package com.serasa.api.api.dtos.sistema.c;

/**
 * @author maria
 * @date 18/05/2025
 * @description Classe ConsultasBureauDTO
 */
public class SistemaCConsultaBureauDTO {
    public String data;
    public String consultadoPor;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConsultadoPor() {
        return consultadoPor;
    }

    public void setConsultadoPor(String consultadoPor) {
        this.consultadoPor = consultadoPor;
    }
}