package br.com.warnit.address.repository;

import br.com.warnit.address.model.domain.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Guilherme Camargo
 * @since 29/01/2019
 * @version 1.0
 * */
@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
}
