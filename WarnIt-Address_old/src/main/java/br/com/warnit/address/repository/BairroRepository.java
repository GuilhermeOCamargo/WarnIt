package br.com.warnit.address.repository;

import br.com.warnit.address.model.domain.Bairro;
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
public interface BairroRepository extends JpaRepository<Bairro, Long> {
    @Transactional(readOnly = true)
    Optional<Bairro> findByNome(String nomeBairro);
}
