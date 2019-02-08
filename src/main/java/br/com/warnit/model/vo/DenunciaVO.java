package br.com.warnit.model.vo;

import br.com.warnit.model.domain.Denuncia;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 06/02/2019
 * @version 1.0
 * */
public class DenunciaVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String detalhes;
    private String categoria;
    /*Localidade*/
    private String nomeLocalidade;
    private String cep;
    /*Bairro*/
    private String nomeBairro;
    /*Cidade*/
    private String nomeCidade;
    /*Estado*/
    private String nomeEstado;
    private String uf;

    public DenunciaVO(Denuncia denuncia){
        this.detalhes = denuncia.getDetalhes();
        this.categoria = denuncia.getCategoria().getNome();
        this.nomeLocalidade = denuncia.getLocalidade().getNomeRua();
        this.cep = denuncia.getLocalidade().getCep();
        this.nomeBairro = denuncia.getLocalidade().getBairro().getNome();
        this.nomeCidade = denuncia.getLocalidade().getBairro().getCidade().getNome();
        this.nomeEstado = denuncia.getLocalidade().getBairro().getCidade().getEstado().getNomeEstado();
        this.uf = denuncia.getLocalidade().getBairro().getCidade().getEstado().getUf();
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
}
