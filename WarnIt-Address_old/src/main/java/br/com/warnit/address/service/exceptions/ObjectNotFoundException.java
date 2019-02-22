package br.com.warnit.address.service.exceptions;
/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
