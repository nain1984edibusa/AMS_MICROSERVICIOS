package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.mappers;

import java.util.List;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.dto.ProductoDTO;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.entity.ProductoEntity;

public interface ProductoMapper {

	ProductoDTO toDTO(ProductoEntity e);
	
	List<ProductoDTO> toDTO(List<ProductoEntity>lst);
	
}
