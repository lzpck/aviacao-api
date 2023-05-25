package tech.devinhouse.aviacao.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.devinhouse.aviacao.exception.EntidadeNaoEncontradaException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}