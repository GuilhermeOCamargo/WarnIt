package br.com.warnit.address.util.builder;

import br.com.warnit.address.model.domain.Estado;

/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Estado} object to tests
 * */
public class EstadoBuilder {
    private Estado estado;

    private EstadoBuilder(){}

    public static EstadoBuilder create(){
        EstadoBuilder builder = new EstadoBuilder();
        builder.estado = new Estado();
        builder.estado.setNomeEstado("São Paulo");
        builder.estado.setUf("SP");
        return builder;
    }

    public Estado get(){
        return estado;
    }
}
