package br.com.warnit.address.model.vo;

import br.com.warnit.address.model.domain.Logradouro;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 06/02/2019
 * @version 1.0
 * */
public class LogradouroVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /*Logradouro*/
    private Long idLogradouro;
    private String numero;
    private String complemento;
    /*Localidade*/
    private Long idLocalidade;
    private String nomeLocalidade;
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

    public LogradouroVO(Logradouro log){
        this.idLogradouro = idLogradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.idLocalidade = idLocalidade;
        this.nomeLocalidade = nomeLocalidade;
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
}
