package br.com.warnit.model.dto;

import br.com.warnit.model.domain.Usuario;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 03/02/2019
 * @version 1.0
 * */
public class UsuarioRespDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;

    public UsuarioRespDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public UsuarioRespDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
