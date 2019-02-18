package br.com.warnit.address;

import br.com.warnit.address.model.domain.Logradouro;
import br.com.warnit.address.repository.LogradouroRepository;
import br.com.warnit.address.util.builder.LogradouroBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class WarnItAddressApplication implements CommandLineRunner {

	@Autowired
	private LogradouroRepository logradouroRepository;

	public static void main(String[] args) {
		SpringApplication.run(WarnItAddressApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Logradouro Completo*/
		Logradouro logradouro = LogradouroBuilder.create().get();
		logradouro = logradouroRepository.save(logradouro);
	}
}
@Configuration
class RestTemplateConfig {

	// Create a bean for restTemplate to call services
	@Bean
	@LoadBalanced        // Load balance between service instances running at different ports.
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
