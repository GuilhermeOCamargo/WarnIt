package br.com.warnit.address

import br.com.warnit.address.service.LocalidadeService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class WarnItAddressApplication(private val localidadeService: LocalidadeService) : CommandLineRunner {

	override fun run(vararg args: String?) {

	}
}

fun main(args: Array<String>) {
	runApplication<WarnItAddressApplication>(*args)
}
