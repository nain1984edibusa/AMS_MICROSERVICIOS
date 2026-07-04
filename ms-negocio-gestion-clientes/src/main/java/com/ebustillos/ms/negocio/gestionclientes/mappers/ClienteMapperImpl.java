package com.ebustillos.ms.negocio.gestionclientes.mappers;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ebustillos.ms.negocio.gestionclientes.dto.ClienteDTO;
import com.ebustillos.ms.negocio.gestionclientes.entity.ClienteEntity;



@Component
public class ClienteMapperImpl implements ClienteMapper {

	@Override
	public ClienteDTO toDTO(ClienteEntity e) {
		return ClienteDTO.builder()
							.id(e.getId())
							.razonSocial(e.getRazonSocial())
							.correo(e.getCorreo())
							.ruc(e.getRuc())
							.telefono(e.getTelefono())
							.estado(e.getEstado())
							.direccion(e.getDireccion()).build();
	}

	@Override
	public List<ClienteDTO> toDTO(List<ClienteEntity> lst) {
		return lst.stream().map(e -> toDTO(e)).toList();
	}

}
