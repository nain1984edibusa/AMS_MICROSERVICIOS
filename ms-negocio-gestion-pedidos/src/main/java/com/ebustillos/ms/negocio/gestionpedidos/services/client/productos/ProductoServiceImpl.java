package com.ebustillos.ms.negocio.gestionpedidos.services.client.productos;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProductoServiceImpl implements ProductoService {

	// Clasica - No aplica

	/*
	 * private String url="http://localhost:8082/v1/clientes/";
	 * 
	 * private final RestTemplate restTemplate;
	 * 
	 * 
	 * @Override public ClienteDTO findById(Long id) { ResponseEntity<ClienteDTO>
	 * clienteDTO= restTemplate.getForEntity(url+id, ClienteDTO.class);
	 * log.info("clienteDTO  ClienteServiceImpl {}",clienteDTO); return
	 * clienteDTO.getBody(); }
	 */

	// Optima

	private final RestTemplate restTemplate;
	private final DiscoveryClient discoveryClient;

	private final String ms_name = "ms-negocio-gestion-productos"; // host.docker.internal:ms-negocio-gestion-clientes:8082
																	// // Eureka Dashword
	// MS-NEGOCIO-GESTION-CLIENTES

	private String url = "";

	
	@Override
	public ProductoDto findById(Long id) {

		// Clasica
		
		  this.url=this.getURI()+"/api/v1/productos/"+id;
		  
		  log.info("url {}",url);
		  
		  ResponseEntity<ProductoDto> clienteDTO= restTemplate.getForEntity(url,ProductoDto.class);
		  
		  log.info("clienteDTO  ClienteServiceImpl {}",clienteDTO); return
		  clienteDTO.getBody();
		 
	}


	private String getURI() {

		if (Objects.isNull(discoveryClient)) {
			log.info("discoveryClient is null");
			return null;
		}

		List<ServiceInstance> instances = discoveryClient.getInstances(ms_name);

		if (Objects.isNull(instances) || instances.isEmpty()) {
			log.info("instances is null");
			return null;
		}

		log.info("instances.get(0).getHost() => {}", instances.get(0).getHost());

		String uri = instances.get(0).getUri().toString();
		log.info("uri => {}", uri);

		return uri;
	}

}
