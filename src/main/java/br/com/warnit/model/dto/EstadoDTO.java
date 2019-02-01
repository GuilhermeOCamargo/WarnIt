package br.com.warnit.model.dto;

import br.com.warnit.model.DtoInterface;
import br.com.warnit.model.domain.Estado;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class EstadoDTO implements Serializable, DtoInterface<Estado> {
    private static final long serialVersionUID = 1L;

    private String nomeEstado;
    private String uf;

    public EstadoDTO(String nomeEstado, String uf) {
        this.nomeEstado = nomeEstado;
        this.uf = uf;
    }

    @Override
    public Estado getObject(){
        return new Estado(nomeEstado, uf);
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
