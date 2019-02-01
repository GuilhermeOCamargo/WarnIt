package br.com.warnit.model.dto;

import br.com.warnit.model.DtoInterface;
import br.com.warnit.model.domain.Logradouro;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class LogradouroDTO implements Serializable, DtoInterface<Logradouro> {
    private static final long serialVersionUID = 1L;

    private RuaDTO rua;
    private String numero;
    private String complemento;

    public LogradouroDTO(RuaDTO rua, String numero, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public Logradouro getObject() {
        return new Logradouro(rua.getObject(), numero, complemento);
    }

    public RuaDTO getRua() {
        return rua;
    }

    public void setRua(RuaDTO rua) {
        this.rua = rua;
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
}
