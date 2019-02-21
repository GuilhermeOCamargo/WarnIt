package br.com.warnit.model.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class LogradouroDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long idLogradouro;
    @NotNull(message = "Insira o número do logradouro.")
    private String numero;
    private String complemento;
    @NotNull(message = "Insira o nome da rua.")
    private String nomeRua;
    @NotNull(message = "Insira do CEP.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Cep inválido.")
    private String cep;

    public LogradouroDTO(Long idLogradouro, String numero, String complemento, String nomeRua, String cep) {
        this.idLogradouro = idLogradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.nomeRua = nomeRua;
        this.cep = cep;
    }

    public Long getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Long idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
