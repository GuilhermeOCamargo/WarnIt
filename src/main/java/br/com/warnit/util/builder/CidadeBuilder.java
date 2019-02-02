package br.com.warnit.util.builder;

import br.com.warnit.model.domain.Cidade;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Cidade} object to tests
 * */
public class CidadeBuilder {

    private Cidade cidade;

    private CidadeBuilder(){}

    public static CidadeBuilder create(){
        CidadeBuilder builder = new CidadeBuilder();
        builder.cidade = new Cidade();
        builder.cidade.setId(null);
        builder.cidade.setEstado(EstadoBuilder.create().get());
        builder.cidade.setNome("Guarulhos");
        return builder;
    }

    public Cidade get(){
        return cidade;
    }
}
