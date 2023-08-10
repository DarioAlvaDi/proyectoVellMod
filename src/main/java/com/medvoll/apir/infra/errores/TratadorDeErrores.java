package com.medvoll.apir.infra.errores;

import java.security.PublicKey;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import lombok.experimental.var;

@RestControllerAdvice
public class TratadorDeErrores {
	
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	
	public ResponseEntity<Void> tratarError404(){
		
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        //var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().build();
    }
	
	
	
	
	
	
	
	public static class DatosErrorValidacion {
        private final String nombre;
        private final String errorDTO;
        public DatosErrorValidacion(FieldError error) {
            this.nombre = error.getField();
            this.errorDTO = error.getDefaultMessage();
        }
	}
	
}

