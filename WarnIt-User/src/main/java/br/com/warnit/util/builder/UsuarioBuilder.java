package br.com.warnit.util.builder;

import br.com.warnit.model.domain.Usuario;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 *
 * This Class creates a standard {@link Usuario} object to tests
 * */
public class UsuarioBuilder {
    private Usuario usuario;

    private UsuarioBuilder(){}

    public static UsuarioBuilder create(){
        UsuarioBuilder builder = new UsuarioBuilder();
        builder.usuario = new Usuario();
        builder.usuario.setNome("Guilherme Camargo");
        builder.usuario.setEmail("guilherme.ocamargo@gmail.com");
        builder.usuario.setSenha("1234");
        return builder;
    }

    public Usuario get(){
        return usuario;
    }
}
