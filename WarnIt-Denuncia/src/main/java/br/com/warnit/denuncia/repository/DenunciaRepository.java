package br.com.warnit.denuncia.repository;

import br.com.warnit.denuncia.model.domain.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
}
