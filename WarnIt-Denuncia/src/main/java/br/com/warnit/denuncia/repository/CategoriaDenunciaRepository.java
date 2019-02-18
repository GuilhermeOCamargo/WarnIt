package br.com.warnit.denuncia.repository;

import br.com.warnit.denuncia.model.domain.CategoriaDenuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDenunciaRepository extends JpaRepository<CategoriaDenuncia, Long> {
}
