package br.com.warnit.address.util.builder;

import br.com.warnit.address.model.domain.Localidade;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Localidade} object to tests
 * */
public class LocalidadeBuilder {

    private Localidade localidade;

    private LocalidadeBuilder(){}

    public static LocalidadeBuilder create(){
        LocalidadeBuilder builder = new LocalidadeBuilder();
        builder.localidade = new Localidade();
        builder.localidade.setId(null);
        builder.localidade.setNomeRua("Localidade xpto");
        builder.localidade.setCep("00000000");
        builder.localidade.setBairro(BairroBuilder.create().get());
        return builder;
    }

    public Localidade get(){
        return localidade;
    }
}
