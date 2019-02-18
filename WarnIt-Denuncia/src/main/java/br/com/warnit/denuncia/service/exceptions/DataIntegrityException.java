package br.com.warnit.denuncia.service.exceptions;
/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class DataIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }
}
