package br.com.warnit.repository;

import br.com.warnit.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Transactional(readOnly = true)
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    @Transactional(readOnly = true)
    Optional<Usuario> findByEmail(String email);

}
