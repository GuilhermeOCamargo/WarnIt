package br.com.warnit.address.model.dto;

import br.com.warnit.address.model.domain.Logradouro;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotNull(message = "Insira o número do logradouro.")
    private String numero;
    private String complemento;
    /*Localidade*/
    private Long idLocalidade;
    @NotNull(message = "Insira o nome da rua.")
    private String nomeLocalidade;
    @NotNull(message = "Insira do CEP.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Cep inválido.")
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
    /*Usuario*/
    private Long usuarioId;
    public LogradouroDTO(Long idLogradouro, String numero, String complemento, Long idLocalidade, String nomeLocalidade,
                         String cep, Long idBairro, String nomeBairro, Long idCidade, String nomeCidade,
                         Long idEstado, String nomeEstado, String uf, Long usuarioId) {
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
        this.usuarioId = usuarioId;
    }
    public LogradouroDTO(Logradouro log){
        this.idLogradouro = log.getId();
        this.numero = log.getNumero();
        this.complemento = this.getComplemento();
        this.idLocalidade = log.getLocalidade().getId();
        this.nomeLocalidade = log.getLocalidade().getNomeRua();
        this.cep = log.getLocalidade().getCep();
        this.idBairro = log.getLocalidade().getBairro().getId();
        this.nomeBairro = log.getLocalidade().getBairro().getNome();
        this.idCidade = log.getLocalidade().getBairro().getCidade().getId();
        this.nomeCidade = log.getLocalidade().getBairro().getCidade().getNome();
        this.idEstado = log.getLocalidade().getBairro().getCidade().getEstado().getId();
        this.nomeEstado = log.getLocalidade().getBairro().getCidade().getEstado().getNomeEstado();
        this.uf = log.getLocalidade().getBairro().getCidade().getEstado().getUf();
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
