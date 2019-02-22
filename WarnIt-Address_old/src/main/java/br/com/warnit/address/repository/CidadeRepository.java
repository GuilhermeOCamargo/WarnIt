package br.com.warnit.address.repository;

import br.com.warnit.address.model.domain.Cidade;
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
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Transactional(readOnly = true)
    Optional<Cidade> findByNome(String nomeCidade);
}