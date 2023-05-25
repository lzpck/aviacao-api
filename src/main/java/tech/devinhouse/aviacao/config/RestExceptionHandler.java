package tech.devinhouse.aviacao.config;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.devinhouse.aviacao.exception.EntidadeJaExisteException;
import tech.devinhouse.aviacao.exception.NotFound;
import tech.devinhouse.aviacao.web.ErroResponse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeJaExisteException.class)
    public ResponseEntity<Object> handleRegistroExistenteException(EntidadeJaExisteException e) {
        ErroResponse erro = new ErroResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Object> handleRegistroNaoEncontradoException(NotFound e) {
        ErroResponse erro = new ErroResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getConstraintViolations().forEach(e -> {
            Iterator<Path.Node> iterator = e.getPropertyPath().iterator();
            String fieldName = null;
            while(iterator.hasNext()) {
                fieldName = iterator.next().getName();
            }
            String errorMessage = e.getMessage();
            fieldErrors.put(fieldName, errorMessage);
        });
        ErroResponse erro = new ErroResponse("Erro de validação", fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
