package br.com.warnit.util.builder;

import br.com.warnit.model.domain.Logradouro;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Logradouro} object to tests
 * */
public class LogradouroBuilder {

    public Logradouro logradouro;

    private LogradouroBuilder(){}

    public static LogradouroBuilder create(){
        LogradouroBuilder builder = new LogradouroBuilder();
        builder.logradouro = new Logradouro();
        builder.logradouro.setId(null);
        builder.logradouro.setNumero("1");
        builder.logradouro.setComplemento("Apto. 10, 2º Andar");
        builder.logradouro.setRua(RuaBuilder.create().get());
        return builder;
    }

    public Logradouro get(){
        return logradouro;
    }
}
