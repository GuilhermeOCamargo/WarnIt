package br.com.warnit.denuncia.service.exceptions;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException(String s) {
        super(s);
    }
}
