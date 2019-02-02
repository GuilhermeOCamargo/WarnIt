package br.com.warnit;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.model.domain.Usuario;
import br.com.warnit.repository.LogradouroRepository;
import br.com.warnit.repository.UsuarioRepository;
import br.com.warnit.util.builder.LogradouroBuilder;
import br.com.warnit.util.builder.UsuarioBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarnItApplication implements CommandLineRunner {

	@Autowired
	private LogradouroRepository logradouroRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(WarnItApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Logradouro Completo*/
		Logradouro logradouro = LogradouroBuilder.create().get();
		logradouro = logradouroRepository.save(logradouro);

		/*Usuario*/
		Usuario usuario = UsuarioBuilder.create().get();
		usuario.setLogradouro(logradouro);
		usuarioRepository.save(usuario);
	}
}

