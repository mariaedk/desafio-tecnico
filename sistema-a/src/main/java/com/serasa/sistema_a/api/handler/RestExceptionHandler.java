package com.serasa.sistema_a.api.handler;

import com.serasa.sistema_a.domain.exceptions.ValidationError;
import com.serasa.sistema_a.domain.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * @author maria
 * @date 17/05/2025
 * @description Lida com as exceções que podem ocorrer nos controllers.
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiError> genericException(ValidationException ex) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setCode(HttpStatus.BAD_REQUEST.value());
        apiError.setStatus(HttpStatus.BAD_REQUEST.name());
        apiError.setErrors(ex.getErros().stream().map(ValidationError::getMensagem).collect(Collectors.toList()));
        return ResponseEntity.badRequest().body(apiError);
    }

}
