package com.ebustillos.ms.negocio.gestionproductos.mappers;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ebustillos.ms.negocio.gestionproductos.dto.ProductoDTO;
import com.ebustillos.ms.negocio.gestionproductos.entity.ProductoEntity;

@Component
public class ProductoMapperImpl implements ProductoMapper {

	@Override
	public ProductoDTO toDTO(ProductoEntity e) {
		return ProductoDTO.builder().id(e.getId()).nombre(e.getNombre()).precio(e.getPrecio())
				.stock(e.getStock()).build();
	}

	@Override
	public List<ProductoDTO> toDTO(List<ProductoEntity> lst) {
		return lst.stream().map(e -> toDTO(e)).toList();
	}

}
