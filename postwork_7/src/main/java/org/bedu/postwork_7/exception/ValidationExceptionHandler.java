package org.bedu.postwork_7.exception;

import org.bedu.postwork_7.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDTO> handleValidationException(MethodArgumentNotValidException ex) {
        // Obtener los errores de validación
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        // Crear una lista de mensajes de error
        List<String> errors = fieldErrors.stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        // Crear la respuesta de error
        ResponseErrorDTO errorResponse = ResponseErrorDTO.builder()
                .message("Error de validación")
                .errors(errors).build();

        // Devolver una respuesta con el código de estado apropiado
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


}
