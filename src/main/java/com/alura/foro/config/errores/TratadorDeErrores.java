
package com.alura.foro.config.errores;

import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(value = {EntityNotFoundException.class, MissingPathVariableException.class})
    public ResponseEntity tratarError404() {
        //return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(message404());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity tratarError400(MethodArgumentNotValidException ex) {
        var errores = ex.getFieldErrors().stream().map(datosErrorDeValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    //  Filtrar información para mostrar al cliente en tratarError400
    private record datosErrorDeValidacion(String campo, String error) {

        public datosErrorDeValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }

    //  Mensaje para codigo de respuesta 404
    private Map<String, String> message404() {
        Map<String, String> data = new HashMap<>();
        data.put("message", "record not found");
        return data;
    }

}
