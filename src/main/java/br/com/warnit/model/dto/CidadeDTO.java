package br.com.warnit.model.dto;

import br.com.warnit.model.DtoInterface;
import br.com.warnit.model.domain.Cidade;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class CidadeDTO implements Serializable, DtoInterface<Cidade> {
    private static final long serialVersionUID = 1L;

    private String nome;
    private EstadoDTO estado;

    public CidadeDTO(String nome, EstadoDTO estado) {
        this.nome = nome;
        this.estado = estado;
    }
    @Override
    public Cidade getObject(){
        return new Cidade(nome, estado.getObject());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }
}
