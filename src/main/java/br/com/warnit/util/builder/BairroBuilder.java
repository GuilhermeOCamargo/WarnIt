package br.com.warnit.util.builder;

import br.com.warnit.model.domain.Bairro;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Bairro} object to tests
 * */
public class BairroBuilder {

    private Bairro bairro;

    private BairroBuilder(){}

    public static BairroBuilder create(){
        BairroBuilder builder = new BairroBuilder();
        builder.bairro = new Bairro();
        builder.bairro.setId(null);
        builder.bairro.setNome("Bairro dos Pimentas");
        builder.bairro.setCidade(CidadeBuilder.create().get());
        return builder;
    }

    public Bairro get(){
        return bairro;
    }
}
