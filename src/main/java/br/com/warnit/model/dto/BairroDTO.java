package br.com.warnit.model.dto;

import br.com.warnit.model.DtoInterface;
import br.com.warnit.model.domain.Bairro;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 31/01/2019
 * @version 1.0
 * */
public class BairroDTO implements Serializable, DtoInterface<Bairro> {
    private static final long serialVersionUID = 1L;

    private String nome;
    private CidadeDTO cidade;

    public BairroDTO(String nome, CidadeDTO cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    @Override
    public Bairro getObject(){
        return new Bairro(nome, cidade.getObject());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CidadeDTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDTO cidade) {
        this.cidade = cidade;
    }
}
