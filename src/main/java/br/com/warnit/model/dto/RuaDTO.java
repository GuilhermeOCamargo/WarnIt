package br.com.warnit.model.dto;

import br.com.warnit.model.DtoInterface;
import br.com.warnit.model.domain.Rua;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class RuaDTO implements Serializable, DtoInterface<Rua> {
    private static final long serialVersionUID = 1L;

    private String nomeRua;
    private String cep;
    private BairroDTO bairro;

    public RuaDTO(String nomeRua, String cep, BairroDTO bairro) {
        this.nomeRua = nomeRua;
        this.cep = cep;
        this.bairro = bairro;
    }

    @Override
    public Rua getObject() {
        return new Rua(nomeRua, bairro.getObject(), cep);
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

    public BairroDTO getBairro() {
        return bairro;
    }

    public void setBairro(BairroDTO bairro) {
        this.bairro = bairro;
    }
}
