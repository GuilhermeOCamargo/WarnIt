package br.com.warnit.repository;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface LogradouroRepository extends CrudRepository<Logradouro, Long> {

    @Transactional(readOnly = true)
    Optional<Logradouro> findByUsuario(Usuario usuario);
}
