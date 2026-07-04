package com.ebustillos.ms.negocio.gestionpedidos.services.client.clientes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {

	private Long id;
	
	private String razonSocial;
	
	private String ruc;
}

