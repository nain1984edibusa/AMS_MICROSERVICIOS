package com.ebustillos.ms.negocio.gestionproductos.mappers;

import java.util.List;
import com.ebustillos.ms.negocio.gestionproductos.dto.ProductoDTO;
import com.ebustillos.ms.negocio.gestionproductos.entity.ProductoEntity;

public interface ProductoMapper {

	ProductoDTO toDTO(ProductoEntity e);
	
	List<ProductoDTO> toDTO(List<ProductoEntity>lst);
	
}
