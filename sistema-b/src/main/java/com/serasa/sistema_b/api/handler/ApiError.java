package com.serasa.sistema_b.api.handler;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author maria
 * @date 17/05/2025
 * @description Implementação para o retorno de erros na api
 */
public class ApiError {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private Integer code;
    private String status;
    private List<String> errors;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

