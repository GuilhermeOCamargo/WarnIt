package br.com.warnit.repository;

import br.com.warnit.model.domain.Localidade;
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
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

    @Transactional(readOnly = true)
    Optional<Localidade> findByCep(String cep);
}
