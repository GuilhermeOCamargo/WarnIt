package br.com.warnit.model.dto;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
public class UsuarioLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;

    public UsuarioLoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
