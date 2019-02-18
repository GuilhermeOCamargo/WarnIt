package br.com.warnit.service.exceptions;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException(String s) {
        super(s);
    }
}
