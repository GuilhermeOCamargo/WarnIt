package br.com.warnit.model.vo;

import br.com.warnit.model.domain.Logradouro;

import java.io.Serializable;

public class LogradouroVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idLogradouro;
    private String numero;
    private String complemento;
    private String nomeRua;
    private String cep;

    public LogradouroVO(Logradouro logradouro) {
        this.idLogradouro = logradouro.getId();
        this.cep = logradouro.getCep();
        this.complemento = logradouro.getComplemento();
        this.nomeRua = logradouro.getNomeRua();
        this.numero = logradouro.getNumero();
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
