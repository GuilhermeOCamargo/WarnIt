package br.com.warnit;

import br.com.warnit.model.domain.Usuario;
import br.com.warnit.repository.UsuarioRepository;
import br.com.warnit.util.builder.UsuarioBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WarnItUserApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(WarnItUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario*/
		Usuario usuario = UsuarioBuilder.create().get();
		usuarioRepository.save(usuario);
	}
}
