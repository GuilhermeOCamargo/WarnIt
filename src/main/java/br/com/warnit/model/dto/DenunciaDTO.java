package br.com.warnit.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 06/02/2019
 * @version 1.0
 * */
public class DenunciaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Length(max = 500, message = "Limite de caracteres excedido.")
    private String detalhes;
    /*Categoria*/
    private Long idCategoria;
    private String nomeCategoria;
    /*Localidade*/
    private Long idLocalidade;
    @NotNull(message = "Insira o nome da rua.")
    private String nomeLocalidade;
    @NotNull(message = "Insira do CEP.")
    @Pattern(regexp = "\\d{5}\\d{3}", message = "Cep inválido.")
    private String cep;
    /*Bairro*/
    private Long idBairro;
    @NotNull(message = "Insira o bairro.")
    private String nomeBairro;
    /*Cidade*/
    private Long idCidade;
    @NotNull(message = "Insira a cidade.")
    private String nomeCidade;
    /*Estado*/
    private Long idEstado;
    @NotNull(message = "Insira o estado.")
    private String nomeEstado;
    @NotNull(message = "Insira a UF.")
    @Size(min = 2, max = 2, message = "UF Inválida.")
    private String uf;



    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Long getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Long idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
