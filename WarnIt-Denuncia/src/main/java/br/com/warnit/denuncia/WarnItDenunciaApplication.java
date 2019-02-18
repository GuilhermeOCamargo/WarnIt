package br.com.warnit.denuncia;

import br.com.warnit.denuncia.util.builder.CategoriaDenunciaBuilder;
import br.com.warnit.denuncia.util.builder.DenunciaBuilder;
import br.com.warnit.denuncia.model.domain.CategoriaDenuncia;
import br.com.warnit.denuncia.model.domain.Denuncia;
import br.com.warnit.denuncia.repository.CategoriaDenunciaRepository;
import br.com.warnit.denuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WarnItDenunciaApplication implements CommandLineRunner {

	@Autowired
	private DenunciaRepository denunciaRepository;
	@Autowired
	private CategoriaDenunciaRepository categoriaDenunciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(WarnItDenunciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Categoria Denuncia*/
		CategoriaDenuncia categoriaDenuncia = CategoriaDenunciaBuilder.create().get();
		categoriaDenunciaRepository.save(categoriaDenuncia);

		/*Denuncia*/
		Denuncia denuncia = DenunciaBuilder.create().get();
		denuncia.setCategoria(categoriaDenuncia);
		denuncia.setLocalidade(1L);
		denunciaRepository.save(denuncia);
	}
}

