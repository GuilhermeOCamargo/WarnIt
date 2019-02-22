package br.com.warnit.address

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class WarnItAddressApplication

fun main(args: Array<String>) {
	runApplication<WarnItAddressApplication>(*args)
}
