package com.ebustillos.ms.negocio.gestionclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsNegocioGestionClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionClientesApplication.class, args);
	}

}
