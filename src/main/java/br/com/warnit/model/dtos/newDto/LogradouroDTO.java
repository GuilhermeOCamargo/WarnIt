package br.com.warnit.model.dtos.newDto;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class LogradouroDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    /*Logradouro*/
    private Long idLogradouro;
    private String numero;
    private String complemento;
    /*Rua*/
    private Long idRua;
    private String nomeRua;
    private String cep;
    /*Bairro*/
    private Long idBairro;
    private String nomeBairro;
    /*Cidade*/
    private Long idCidade;
    private String nomeCidade;
    /*Estado*/
    private Long idEstado;
    private String nomeEstado;
    private String uf;

    public LogradouroDTO(Long idLogradouro, String numero, String complemento, Long idRua, String nomeRua, String cep, Long idBairro, String nomeBairro, Long idCidade, String nomeCidade, Long idEstado, String nomeEstado, String uf) {
        this.idLogradouro = idLogradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.idRua = idRua;
        this.nomeRua = nomeRua;
        this.cep = cep;
        this.idBairro = idBairro;
        this.nomeBairro = nomeBairro;
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
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

    public Long getIdRua() {
        return idRua;
    }

    public void setIdRua(Long idRua) {
        this.idRua = idRua;
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

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
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

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
