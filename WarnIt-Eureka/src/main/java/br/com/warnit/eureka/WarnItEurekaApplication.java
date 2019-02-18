package br.com.warnit.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WarnItEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarnItEurekaApplication.class, args);
	}

}
