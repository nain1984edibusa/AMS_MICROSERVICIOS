package com.ebustillos.ms.negocio.gestionpedidos.services.client.productos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDto {

	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	private Integer stock;
}

