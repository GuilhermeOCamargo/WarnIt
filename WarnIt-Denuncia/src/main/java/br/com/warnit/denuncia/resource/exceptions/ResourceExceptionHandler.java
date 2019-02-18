package br.com.warnit.denuncia.resource.exceptions;

import br.com.warnit.denuncia.service.exceptions.AuthenticationFailedException;
import br.com.warnit.denuncia.service.exceptions.DataIntegrityException;
import br.com.warnit.denuncia.service.exceptions.ObjectNotFoundException;
import br.com.warnit.denuncia.service.exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@ControllerAdvice
public class ResourceExceptionHandler {
    /**
     * @param e - Exception that must be handled
     * @param req - HttpServletRequest
     * @return Default json error to handle {@link ObjectNotFoundException}
     * */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    /**
     * @param e - Exception that must be handled
     * @param req - HttpServletRequest
     * @return Default json error to handle {@link DataIntegrityException}
     * */
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest req){
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    /**
     * @param e - Exception that must be handled
     * @param req - HttpServletRequest
     * @return Default json error to handle {@link AuthenticationFailedException}
     * */
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<StandardError> dataIntegrity(AuthenticationFailedException e, HttpServletRequest req){
        StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }
    /**
     * @param e - Exception that must be handled
     * @param req - HttpServletRequest
     * @return Default json error to handle {@link MethodArgumentNotValidException}
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest req){
        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validação.", System.currentTimeMillis());

        for(FieldError fe : e.getBindingResult().getFieldErrors()){
            err.addError(fe.getField(), fe.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
