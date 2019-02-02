package br.com.warnit.service;

import br.com.warnit.model.domain.Usuario;
import br.com.warnit.repository.UsuarioRepository;
import br.com.warnit.service.exceptions.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario authenticate(String email, String senha){
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        return usuario.orElseThrow(() -> new AuthenticationFailedException("Email ou senha incorretos."));
    }
}
