package br.com.warnit.model.dto;

import br.com.warnit.model.domain.Usuario;
import br.com.warnit.validators.annotations.ConfirmSenhaEqualsValid;
import br.com.warnit.validators.annotations.EmailUniqueValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 03/02/2019
 * @version 1.0
 * */
@ConfirmSenhaEqualsValid.List({
        @ConfirmSenhaEqualsValid(senha = "senha", confirmSenha = "confirmSenha")
})
@EmailUniqueValid(email = "email", id = "id")
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "Insira o nome.")
    private String nome;
    @Email(message = "Insira um email válido.")
    private String email;
    @NotNull(message = "Insira a senha.")
    @Size(min = 8, max = 15, message = "A senha deve ter entre 8 e 15 caracteres.")
    private String senha;
    private String confirmSenha;

    public UsuarioDTO(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public UsuarioDTO(){}

    public UsuarioDTO(Usuario user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
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

    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = confirmSenha;
    }
}
