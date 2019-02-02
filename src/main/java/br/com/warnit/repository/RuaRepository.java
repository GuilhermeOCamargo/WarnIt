package br.com.warnit.repository;

import br.com.warnit.model.domain.Rua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Repository
public interface RuaRepository extends JpaRepository<Rua, Long> {

    @Transactional(readOnly = true)
    Optional<Rua> findByCep(String cep);
}
