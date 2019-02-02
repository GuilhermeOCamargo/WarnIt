package br.com.warnit.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false)
    private String senha;
    @OneToOne(optional = true, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, unique = true)
    private Logradouro logradouro;

    public Usuario(Long id, String nome, String email, String senha, Logradouro logradouro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.logradouro = logradouro;
    }
    public Usuario(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) &&
                nome.equals(usuario.nome) &&
                email.equals(usuario.email) &&
                senha.equals(usuario.senha) &&
                logradouro.equals(usuario.logradouro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, logradouro);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
}
