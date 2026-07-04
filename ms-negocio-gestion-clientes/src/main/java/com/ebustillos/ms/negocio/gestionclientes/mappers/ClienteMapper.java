package com.ebustillos.ms.negocio.gestionclientes.mappers;

import java.util.List;

import com.ebustillos.ms.negocio.gestionclientes.dto.ClienteDTO;
import com.ebustillos.ms.negocio.gestionclientes.entity.ClienteEntity;


public interface ClienteMapper {

	ClienteDTO toDTO(ClienteEntity e);
	
	List<ClienteDTO> toDTO(List<ClienteEntity>lst);
	
}
