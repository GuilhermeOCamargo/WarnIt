package br.com.warnit.util.builder;

import br.com.warnit.model.domain.Rua;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Rua} object to tests
 * */
public class RuaBuilder {

    private Rua rua;

    private RuaBuilder(){}

    public static RuaBuilder create(){
        RuaBuilder builder = new RuaBuilder();
        builder.rua = new Rua();
        builder.rua.setId(null);
        builder.rua.setNomeRua("Rua xpto");
        builder.rua.setCep("00000000");
        builder.rua.setBairro(BairroBuilder.create().get());
        return builder;
    }

    public Rua get(){
        return rua;
    }
}
