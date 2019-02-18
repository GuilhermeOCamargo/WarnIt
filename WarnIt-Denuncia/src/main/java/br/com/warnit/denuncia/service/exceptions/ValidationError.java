package br.com.warnit.denuncia.service.exceptions;

import br.com.warnit.denuncia.resource.exceptions.FieldMessage;
import br.com.warnit.denuncia.resource.exceptions.StandardError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme Camargo
 * @since 04/02/2019
 * @version 1.0
 * */
public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }
}
